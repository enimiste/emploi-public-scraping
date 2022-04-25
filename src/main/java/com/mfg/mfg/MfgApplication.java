package com.mfg.mfg;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.mfg.mfg.model.Annonce;
import com.mfg.mfg.repositories.AnnonceRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SpringBootApplication
public class MfgApplication {

    public final static String URL_TEMPLATE = "https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=%s";
    public final static int MAX_PAGES = 10;
    public final static int DATE_LIMIT_DEPOT_DEADLINE = 5;//now().plus(5)<date limite depot

    public static void main(String[] args) {
        SpringApplication.run(MfgApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(AnnonceRepository repository) {
        return args -> {
            try {
                var rand = ThreadLocalRandom.current();
                System.out.println("Start processing");
                //Last page : div[class=pagination] > a[text=Last]
                int nbrTotalPage = getLastPageNumber(String.format(URL_TEMPLATE, 2));
                int nbr = Math.min(MAX_PAGES, nbrTotalPage);
                DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
                System.out.printf("%d/%d pages will be processed\n", nbr, nbrTotalPage);
                TreeSet<Annonce> annonces = new TreeSet<>(
                        Comparator.comparing(Annonce::isOuvertTousFonctionnaires)
                                .thenComparing(Annonce::getDateLimitDepot)
                                .reversed()
                );
                for (int i = 1; i <= nbr; i++) {
                    try {
                        String pageUrl = String.format(URL_TEMPLATE, i);
                        System.out.printf("Fetching items from page %s\n", pageUrl);
                        Set<Annonce> items = fetchSuppliersInfoFrom(pageUrl, formatter);
                        int itemsCount = items.size();
                        System.out.printf("%d items found on page %s\n", itemsCount, pageUrl);
                        if (itemsCount > 0) {
                            System.out.println("Saving items");
                            annonces.addAll(items);
                            System.out.println("Items saved");
                        }
                    } catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    System.out.println("-".repeat(150));
                    if (i < nbr) {
                        int sleepTimeMillis = rand.nextInt(1000, 10000);
                        System.out.printf("Sleeping %.3f sec\n", sleepTimeMillis / 1000f);
                        Thread.sleep(sleepTimeMillis);
                    }
                }
                System.out.printf("%d total items found\n", annonces.size());

                repository.saveAll(annonces);
                repository.findAll().forEach(System.out::println);
                System.out.println("End processing");
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        };
    }

    protected static int getLastPageNumber(String pageUrl) throws Exception {

        var html = fetchPageHtml(pageUrl);
        List<HtmlElement> items = html.getByXPath("//li[@class='page-item']");
        if (!items.isEmpty()) {
            HtmlAnchor itemAnchor = (HtmlAnchor) items.get(items.size() - 1).getLastChild();
            var pattern = Pattern.compile("p=(\\d+)");
            String itemUrl = itemAnchor.getHrefAttribute();
            var match = pattern.matcher(itemUrl);
            if (match.find()) return Integer.parseInt(match.group(1));
        }
        throw new RuntimeException("Last page URL not found");
    }

    private static HtmlPage fetchPageHtml(String pageUrl) throws Exception {
        try (WebClient client = new WebClient()) {
            client.getOptions().setCssEnabled(true);
            client.getOptions().setJavaScriptEnabled(true);
            client.getOptions().setRedirectEnabled(false);
            client.getOptions().setCssEnabled(false);
            return client.getPage(pageUrl);
        }
    }

    protected static Set<Annonce> fetchSuppliersInfoFrom(String pageUrl, DateTimeFormatter formatter) throws Exception {
        var html = fetchPageHtml(pageUrl);
        List<HtmlElement> items = html.getByXPath("//table/tbody/tr");
        System.out.printf("%d results\n", items.size());
        if (!items.isEmpty()) {
            return items.stream()
                    .map(item -> {
                        try {
                            return buildEntityFromRow(html.getUrl(), formatter, (HtmlTableRow) item);
                        } catch (Exception e) {
                            System.out.printf("Error processing Item: %s", e.getMessage());
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .filter(x -> x.getDateLimitDepot() != null)
                    .filter(x -> LocalDate.now().plusDays(DATE_LIMIT_DEPOT_DEADLINE).isBefore(x.getDateLimitDepot()))
                    .collect(Collectors.toSet());
        }
        return Set.of();
    }

    protected static Annonce buildEntityFromRow(URL pageUrl, DateTimeFormatter formatter, HtmlTableRow row) {
        //Organisme
        var cell0 = row.getCell(0);
        var organismeAnchor = (HtmlAnchor) cell0.getLastChild();
        //Nombre postes div
        var cell1 = row.getCell(1);
        List<HtmlElement> nbrPostesDiv = cell1.getByXPath("//strong");
        //Nombre postes serv
        var cell2 = row.getCell(2);
        List<HtmlElement> nbrPostesServ = cell2.getByXPath("//strong");
        //Ouvert
        var cell3 = row.getCell(3);
        var ouvert = cell3.getTextContent();
        //Date limite depot
        var cell4 = row.getCell(4);
        var cell4Txt = cell4.getTextContent();
        //Date limite depot
        var cell5 = row.getCell(5);
        var cell5Txt = cell5.getTextContent();

        return Annonce
                .builder()
                .sourceUrl(pageUrl.toString())
                .url(pageUrl + organismeAnchor.getHrefAttribute())
                .organisme(organismeAnchor.getTextContent())
                .nbrPostesChefDivision(nbrPostesDiv.isEmpty() ? 0 : Integer.parseInt(nbrPostesDiv.get(0).getTextContent().trim()))
                .nbrPostesChefService(nbrPostesServ.isEmpty() ? 0 : Integer.parseInt(nbrPostesServ.get(0).getTextContent().trim()))
                .ouvert(ouvert)
                .ouvertTousFonctionnaires(ouvert.contains("tous") && ouvert.contains("fonctionnaires"))
                .dateLimitDepot(parseDate(formatter, cell4Txt))
                .datePublication(parseDate(formatter, cell5Txt))
                .candidatsConvoques(!row.getCell(6).getByXPath("//a").isEmpty())
                .resultatsSorties(!row.getCell(7).getByXPath("//a").isEmpty())
                .build();
    }

    protected static LocalDate parseDate(DateTimeFormatter formatter, String date) {
        try {
            return LocalDate.parse(date, formatter);
        } catch (Exception e) {
            return null;
        }
    }
}
