package com.mfg.mfg.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ToString.Exclude
    private String sourceUrl;
    private String organisme;
    @EqualsAndHashCode.Include
    private String url;
    private Integer nbrPostesChefDivision;
    private Integer nbrPostesChefService;
    private String ouvert;
    private boolean ouvertTousFonctionnaires;
    private LocalDate datePublication;
    private LocalDate dateLimitDepot;
    private Boolean candidatsConvoques;
    private Boolean resultatsSorties;

    @Override
    public String toString() {
        return """
                Organisme         = %s
                Chef Division     = %d
                Chef Service      = %d
                Ouvert            = %s
                Date Publication  = %s
                Date Limite Depôt = %s
                """
                .stripIndent()
                .formatted(organisme,
                        nbrPostesChefDivision,
                        nbrPostesChefService,
                        ouvert,
                        datePublication.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)),
                        dateLimitDepot.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
    }
}
