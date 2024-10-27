# Fahrgastdaten-Analyseprogramm (V2)

## Version 2.0

### Überblick
Die Version 2.0 des Programms enthält verbesserte JSON-Verarbeitung mit Jackson, erweiterte Fehlerbehandlung und optimierte Leistung durch verbesserte Datenstrukturen.

### Neue Funktionen und Verbesserungen
- Integration der Jackson-Bibliothek für JSON-Verarbeitung
- Verbesserte Fehlerbehandlung
- Optimierte Leistung
- Unterstützung für wöchentliche und monatliche Datengranularität

### Systemvoraussetzungen
- Java Runtime Environment (JRE) 8 oder höher
- Jackson-Bibliothek
- Ausreichend Arbeitsspeicher
- Lesezugriff auf die Eingabedatei

### Abhängigkeiten
- `com.fasterxml.jackson.core:jackson-databind`
- `com.fasterxml.jackson.core:jackson-core`

### Installation
1. Repository klonen oder Quelldateien herunterladen
2. Java und Maven/Gradle installieren
3. Jackson-Abhängigkeiten hinzufügen:
   ```xml
   <!-- Maven -->
   <dependency>
       <groupId>com.fasterxml.jackson.core</groupId>
       <artifactId>jackson-databind</artifactId>
       <version>2.13.0</version>
   </dependency>
   ```
   oder
   ```gradle
   // Gradle
   implementation 'com.fasterxml.jackson.core:jackson-databind:2.13.0'
   ```
4. Java-Dateien kompilieren:
   ```bash
   javac -cp jackson-databind-2.13.0.jar:jackson-core-2.13.0.jar *.java
   ```

### Verwendung
1. JSON-Datei im `src`-Verzeichnis platzieren
2. Programm starten:
   ```bash
   java -cp .:jackson-databind-2.13.0.jar:jackson-core-2.13.0.jar Main
   ```
3. Zeiträume wie in Version 1.0 eingeben
4. 'exit' zum Beenden

### Hauptverbesserungen in Version 2.0

1. Jackson-Integration
   - Ersetzung der manuellen JSON-Verarbeitung durch Jackson
   - Hinzufügung von JSON-Annotationen
   - Verbesserte Fehlerbehandlung bei der JSON-Verarbeitung

2. Code-Optimierung
   - Verbesserte Leistung durch optimierte Datenstrukturen
   - Verbesserter Speicherverbrauch
   - Bessere Behandlung von Null-Werten

3. Fehlerbehandlung
   - Robustere Fehlerprüfung
   - Detailliertere Fehlermeldungen
   - Verbesserte Behandlung fehlerhafter Daten

### Datenspezifikationen
- Datenzeitraum: 2020-02 bis 2024-08
- Datengranularität: Wöchentlich und Monatlich
- Datenformat: JSON
- Unterstützte Zeiträume: Jahr, Quartal, Monat, Woche
- Sprache: Deutsch (Datenbeschriftungen und Ausgabe)

### Erweiterte Fehlerbehandlung
- Ungültiges JSON-Format
- Fehlende oder beschädigte Dateien
- Ungültige Datumsformate
- Ungültige Benutzereingaben
- Wertebereiche außerhalb der Grenzen
- Null-Werte oder fehlende Werte in JSON-Daten

### Mitwirken am Projekt
Um zum Projekt beizutragen:
1. Repository forken
2. Feature-Branch erstellen
3. Änderungen committen
4. Auf den Branch pushen
5. Pull Request erstellen

### Lizenz
Dieses Projekt steht unter der MIT-Lizenz. Siehe LICENSE-Datei für Details.

### Support
Für Support und Fehlerberichte bitte ein Issue im Project-Tracker erstellen.

### Versionshistorie
- 2.0: Jackson-Integration, verbesserte Fehlerbehandlung, optimierte Leistung
- 1.0: Erste Version mit grundlegender Funktionalität
