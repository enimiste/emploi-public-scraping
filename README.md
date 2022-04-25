# Emploi public web site scraping
## Tech :
- Java 17
- Spring Boot 2.6.7
- h2database
- lombok
- htmlunit
- jackson-databind
- 
## Execution
```log
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.7)

2022-04-25 01:40:31.281  INFO 19916 --- [           main] com.mfg.mfg.MfgApplication               : Starting MfgApplication using Java 17.0.1 on DESKTOP-666TTOO with PID 19916 (D:\Codes\Freelance\mfg\target\classes started by user in D:\Codes\Freelance\mfg)
2022-04-25 01:40:31.283  INFO 19916 --- [           main] com.mfg.mfg.MfgApplication               : No active profile set, falling back to 1 default profile: "default"
2022-04-25 01:40:31.660  INFO 19916 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2022-04-25 01:40:31.706  INFO 19916 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 37 ms. Found 1 JPA repository interfaces.
2022-04-25 01:40:32.096  INFO 19916 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-04-25 01:40:32.261  INFO 19916 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2022-04-25 01:40:32.333  INFO 19916 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2022-04-25 01:40:32.388  INFO 19916 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.6.8.Final
2022-04-25 01:40:32.570  INFO 19916 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2022-04-25 01:40:32.680  INFO 19916 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2022-04-25 01:40:33.244  INFO 19916 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2022-04-25 01:40:33.255  INFO 19916 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2022-04-25 01:40:33.649  INFO 19916 --- [           main] com.mfg.mfg.MfgApplication               : Started MfgApplication in 2.69 seconds (JVM running for 3.029)
Start processing
2022-04-25 01:40:36.301  WARN 19916 --- [           main] c.g.htmlunit.IncorrectnessListenerImpl   : Obsolete content type encountered: 'text/javascript'.
10/217 pages will be processed
Fetching items from page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=1
2022-04-25 01:40:38.910  WARN 19916 --- [           main] c.g.htmlunit.IncorrectnessListenerImpl   : Obsolete content type encountered: 'text/javascript'.
10 results
3 items found on page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=1
Saving items
Items saved
------------------------------------------------------------------------------------------------------------------------------------------------------
Sleeping 5,760 sec
Fetching items from page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=2
2022-04-25 01:40:48.688  WARN 19916 --- [           main] c.g.htmlunit.IncorrectnessListenerImpl   : Obsolete content type encountered: 'text/javascript'.
10 results
0 items found on page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=2
------------------------------------------------------------------------------------------------------------------------------------------------------
Sleeping 1,163 sec
Fetching items from page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=3
2022-04-25 01:40:53.199  WARN 19916 --- [           main] c.g.htmlunit.IncorrectnessListenerImpl   : Obsolete content type encountered: 'text/javascript'.
10 results
2 items found on page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=3
Saving items
Items saved
------------------------------------------------------------------------------------------------------------------------------------------------------
Sleeping 8,531 sec
Fetching items from page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=4
2022-04-25 01:41:04.123  WARN 19916 --- [           main] c.g.htmlunit.IncorrectnessListenerImpl   : Obsolete content type encountered: 'text/javascript'.
10 results
0 items found on page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=4
------------------------------------------------------------------------------------------------------------------------------------------------------
Sleeping 4,866 sec
Fetching items from page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=5
2022-04-25 01:41:11.736  WARN 19916 --- [           main] c.g.htmlunit.IncorrectnessListenerImpl   : Obsolete content type encountered: 'text/javascript'.
10 results
0 items found on page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=5
------------------------------------------------------------------------------------------------------------------------------------------------------
Sleeping 2,212 sec
Fetching items from page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=6
2022-04-25 01:41:16.309  WARN 19916 --- [           main] c.g.htmlunit.IncorrectnessListenerImpl   : Obsolete content type encountered: 'text/javascript'.
10 results
0 items found on page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=6
------------------------------------------------------------------------------------------------------------------------------------------------------
Sleeping 5,398 sec
Fetching items from page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=7
2022-04-25 01:41:24.555  WARN 19916 --- [           main] c.g.htmlunit.IncorrectnessListenerImpl   : Obsolete content type encountered: 'text/javascript'.
10 results
0 items found on page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=7
------------------------------------------------------------------------------------------------------------------------------------------------------
Sleeping 2,439 sec
Fetching items from page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=8
2022-04-25 01:41:29.536  WARN 19916 --- [           main] c.g.htmlunit.IncorrectnessListenerImpl   : Obsolete content type encountered: 'text/javascript'.
10 results
0 items found on page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=8
------------------------------------------------------------------------------------------------------------------------------------------------------
Sleeping 9,210 sec
Fetching items from page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=9
2022-04-25 01:41:41.056  WARN 19916 --- [           main] c.g.htmlunit.IncorrectnessListenerImpl   : Obsolete content type encountered: 'text/javascript'.
10 results
0 items found on page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=9
------------------------------------------------------------------------------------------------------------------------------------------------------
Sleeping 7,106 sec
Fetching items from page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=10
2022-04-25 01:41:50.534  WARN 19916 --- [           main] c.g.htmlunit.IncorrectnessListenerImpl   : Obsolete content type encountered: 'text/javascript'.
10 results
0 items found on page https://www.emploi-public.ma/FR/candidaturesListe.asp?c=0&e=0&p=10
------------------------------------------------------------------------------------------------------------------------------------------------------
3 total items found
Organisme         = Ministère de l’Agriculture, de la Pêche maritime, du développement rural et des eaux et forêts - Département de la Pêche maritime
Chef Division     = 1
Chef Service      = 1
Ouvert            = pour tous les fonctionnaires
Date Publication  = 28 mars 2022
Date Limite Depôt = 5 mai 2022

Organisme         = Ministère de l’Equipement et de l’Eau
Chef Division     = 2
Chef Service      = 2
Ouvert            = 
Date Publication  = 21 avril 2022
Date Limite Depôt = 6 mai 2022

Organisme         = Ministère de l’Agriculture, de la Pêche maritime, du développement rural et des eaux et forêts - Département de l’Agriculture
Chef Division     = 2
Chef Service      = 2
Ouvert            = 
Date Publication  = 15 avril 2022
Date Limite Depôt = 5 mai 2022

End processing
2022-04-25 01:41:51.911  INFO 19916 --- [ionShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2022-04-25 01:41:51.912  INFO 19916 --- [ionShutdownHook] .SchemaDropperImpl$DelayedDropActionImpl : HHH000477: Starting delayed evictData of schema as part of SessionFactory shut-down'
2022-04-25 01:41:51.920  INFO 19916 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2022-04-25 01:41:51.922  INFO 19916 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```