import java.util.List;
import java.util.Scanner;

/**
 * Hauptklasse für die Analyse von Fahrgastdaten der BVB.
 * Diese Klasse enthält den Einstiegspunkt des Programms und steuert den Hauptablauf
 * der Datenanalyse und Benutzerinteraktion.
 *
 */
public class Main {
    /**
     * Die Hauptmethode des Programms. Sie lädt die Daten, initialisiert den Analyzer
     * und führt eine Schleife für Benutzeranfragen durch.
     *
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {
        DataLoader loader = new DataLoader("/Users/cemakkaya/IdeaProjects/fahrgaesteBVB/src/100075.json");
        List<PassengerData> data = loader.loadData();

        if (data == null || data.isEmpty()) {
            System.err.println("Fehler: Keine Daten geladen. Programm wird beendet.");
            System.exit(1);
        }

        DataAnalyzer analyzer = new DataAnalyzer(data);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------Version 2------------------");
            System.out.println("");
            System.out.println("Geben Sie einen Zeitraum ein (Jahr, Quartal, Monat oder Woche):");
            System.out.println("Oder geben Sie 'exit' ein, um das Programm zu beenden.");
            System.out.println("");
            System.out.println("---------------------------------------------");
            System.out.println("");
            System.out.println("Beispiel: '2020', '2020-Q1', '2020-02', '2020-W06'");
            System.out.println("Datensatz geht von 2020-02 bis 2024-08.");


            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Programm wird beendet.");
                break;
            }

            AnalysisResult result = analyzer.analyzeByPeriod(input);
            System.out.println(result);
            System.out.println();
        }

        scanner.close();
    }
}