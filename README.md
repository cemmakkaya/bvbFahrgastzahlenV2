# BVB Fahrgastdaten-Analyseprogramm

## Überblick
Dieses Programm analysiert Fahrgastdaten der Basler Verkehrs-Betriebe (BVB). Es ermöglicht die Filterung von Daten nach verschiedenen Zeiträumen und berechnet statistische Kennzahlen wie die minimale, maximale und durchschnittliche Fahrgastanzahl.

## Funktionen
- Laden von Fahrgastdaten aus einer JSON-Datei
- Filterung der Daten nach Jahr, Jahreszeit (Quartal), Monat oder Woche
- Berechnung der minimalen Fahrgastanzahl für den gewählten Zeitraum
- Berechnung der maximalen Fahrgastanzahl für den gewählten Zeitraum
- Berechnung der durchschnittlichen Fahrgastanzahl für den gewählten Zeitraum

## Voraussetzungen
- Java JDK 11 oder höher
- Maven (für die Abhängigkeitsverwaltung)

## Installation
1. Klonen Sie das Repository:
   ```
   git clone [URL des Repositories]
   ```
2. Navigieren Sie in das Projektverzeichnis:
   ```
   cd [Projektverzeichnis]
   ```
3. Kompilieren Sie das Projekt mit Maven:
   ```
   mvn clean install
   ```

## Verwendung
1. Starten Sie das Programm:
   ```
   java -jar target/bvb-fahrgastdaten-analyse-1.0.jar
   ```
2. Folgen Sie den Anweisungen auf dem Bildschirm, um einen Zeitraum einzugeben.
3. Das Programm wird die Analyseergebnisse für den angegebenen Zeitraum anzeigen.

## Eingabeformat
- Jahr: YYYY (z.B. 2023)
- Jahreszeit (Quartal): YYYY-QN (z.B. 2023-Q1)
- Monat: YYYY-MM (z.B. 2023-03)
- Woche: YYYY-WNN (z.B. 2023-W01)

## Projektstruktur
- `Main.java`: Hauptklasse mit der `main`-Methode
- `DataLoader.java`: Lädt die Daten aus der JSON-Datei
- `DataAnalyzer.java`: Analysiert die Fahrgastdaten
- `PassengerData.java`: Repräsentiert die Struktur der Fahrgastdaten
- `AnalysisResult.java`: Enthält die Ergebnisse der Datenanalyse

## Beitragen
Wenn Sie zu diesem Projekt beitragen möchten, erstellen Sie bitte einen Fork des Repositories und reichen Sie einen Pull Request ein.


## Ersteller
Daniel Martin Fluri &
Cem Akkaya

Projektlink: https://github.com/cemmakkaya/fahrgaesteBVB
