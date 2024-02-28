# Architecture Ref. Card 03

Spring Boot Application mit MariaDB Database

## Inbetriebnahme auf eigenem Computer

Projekt herunterladen

```sh
git clone https://gitlab.com/bbwrl/m346-ref-card-03.git
cd m346-ref-card-03
```

Builden des Projektes mit Maven
```sh
$ mvn package
```

Die erstellte Datei kann nun direkt mit Java gestartet werden.
```sh
$ java -DDB_USERNAME="jokedbuser" -DDB_PASSWORD="123456" -jar target/architecture-refcard-03-0.0.1-SNAPSHOT.jar
```

Im Browser ist die App unter der URL http://localhost:8080 erreichbar.