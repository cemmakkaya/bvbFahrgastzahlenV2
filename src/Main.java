import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataLoader loader = new DataLoader("src/100075.json");
        List<PassengerData> data = loader.loadData();
        DataAnalyzer analyzer = new DataAnalyzer(data);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Geben Sie einen Zeitraum ein (Jahr (YYYY), Jahreszeit (YYYY-QN), Monat (YYYY-MM) oder Woche (YYYY-WNN)):");
            System.out.println("Oder geben Sie 'exit' ein, um das Programm zu beenden.");

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