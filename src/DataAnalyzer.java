import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse analysiert Fahrgastdaten für verschiedene Zeiträume.
 *
 */
public class DataAnalyzer {
    private List<PassengerData> data;

    /**
     * Konstruktor für den DataAnalyzer.
     *
     * @param data Eine Liste von PassengerData-Objekten zur Analyse.
     */
    public DataAnalyzer(List<PassengerData> data) {
        this.data = data;
    }

    /**
     * Analysiert die Fahrgastdaten für einen bestimmten Zeitraum.
     *
     * @param period Der zu analysierende Zeitraum (Jahr, Jahreszeit, Monat oder Woche).
     * @return Ein AnalysisResult-Objekt mit den Analyseergebnissen.
     */
    public AnalysisResult analyzeByPeriod(String period) {
        List<PassengerData> filteredData = filterByPeriod(period);

        if (filteredData.isEmpty()) {
            return new AnalysisResult(0, 0, 0, period);
        }

        int minPassengers = getMinPassengers(filteredData);
        int maxPassengers = getMaxPassengers(filteredData);
        double avgPassengers = getAveragePassengers(filteredData);

        return new AnalysisResult(minPassengers, maxPassengers, avgPassengers, period);
    }

    /**
     * Filtert die Daten nach dem angegebenen Zeitraum.
     *
     * @param period Der Zeitraum für die Filterung.
     * @return Eine gefilterte Liste von PassengerData-Objekten.
     */
    private List<PassengerData> filterByPeriod(String period) {
        List<PassengerData> filteredData = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            PassengerData d = data.get(i);
            if (matchesPeriod(d, period)) {
                filteredData.add(d);
            }
        }
        return filteredData;
    }

    /**
     * Überprüft, ob ein PassengerData-Objekt zum angegebenen Zeitraum passt.
     *
     * @param d Das zu überprüfende PassengerData-Objekt.
     * @param period Der zu überprüfende Zeitraum.
     * @return true, wenn das Objekt zum Zeitraum passt, sonst false.
     */
    private boolean matchesPeriod(PassengerData d, String period) {
        LocalDate date = LocalDate.parse(d.getStartDate(), DateTimeFormatter.ISO_DATE);

        if (period.matches("\\d{4}")) { // Jahr
            return date.getYear() == Integer.parseInt(period);
        } else if (period.matches("\\d{4}-Q[1-4]")) { // Quartal
            int year = Integer.parseInt(period.substring(0, 4));
            int quarter = Integer.parseInt(period.substring(6));
            return date.getYear() == year && ((date.getMonthValue() - 1) / 3 + 1) == quarter;
        } else if (period.matches("\\d{4}-\\d{2}")) { // Monat
            return d.getStartDate().startsWith(period) || (d.getMonthlyDate() != null && d.getMonthlyDate().startsWith(period));
        } else if (period.matches("\\d{4}-W\\d{2}")) { // Woche
            return d.getStartDate().startsWith(period.substring(0, 4)) && d.getCalendarWeek() != null &&
                    d.getCalendarWeek() == Integer.parseInt(period.substring(6));
        }
        return false;
    }

    /**
     * Berechnet die minimale Fahrgastanzahl aus den gefilterten Daten.
     *
     * @param filteredData Die gefilterte Liste von PassengerData-Objekten.
     * @return Die minimale Fahrgastanzahl.
     */
    private int getMinPassengers(List<PassengerData> filteredData) {
        if (filteredData.isEmpty()) {
            return 0;
        }
        int min = filteredData.get(0).getPassengers();
        for (int i = 1; i < filteredData.size(); i++) {
            int passengers = filteredData.get(i).getPassengers();
            if (passengers < min) {
                min = passengers;
            }
        }
        return min;
    }

    /**
     * Berechnet die maximale Fahrgastanzahl aus den gefilterten Daten.
     *
     * @param filteredData Die gefilterte Liste von PassengerData-Objekten.
     * @return Die maximale Fahrgastanzahl.
     */
    private int getMaxPassengers(List<PassengerData> filteredData) {
        if (filteredData.isEmpty()) {
            return 0;
        }
        int max = filteredData.get(0).getPassengers();
        for (int i = 1; i < filteredData.size(); i++) {
            int passengers = filteredData.get(i).getPassengers();
            if (passengers > max) {
                max = passengers;
            }
        }
        return max;
    }

    /**
     * Berechnet die durchschnittliche Fahrgastanzahl aus den gefilterten Daten.
     *
     * @param filteredData Die gefilterte Liste von PassengerData-Objekten.
     * @return Die durchschnittliche Fahrgastanzahl.
     */
    private double getAveragePassengers(List<PassengerData> filteredData) {
        if (filteredData.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < filteredData.size(); i++) {
            sum += filteredData.get(i).getPassengers();
        }
        return (double) sum / filteredData.size();
    }
}

/**
 * Diese Klasse repräsentiert das Ergebnis einer Fahrgastdatenanalyse.
 */
class AnalysisResult {
    private final int minPassengers;
    private final int maxPassengers;
    private final double avgPassengers;
    private final String period;

    /**
     * Konstruktor für ein AnalysisResult-Objekt.
     *
     * @param minPassengers Die minimale Fahrgastanzahl.
     * @param maxPassengers Die maximale Fahrgastanzahl.
     * @param avgPassengers Die durchschnittliche Fahrgastanzahl.
     * @param period Der analysierte Zeitraum.
     */
    public AnalysisResult(int minPassengers, int maxPassengers, double avgPassengers, String period) {
        this.minPassengers = minPassengers;
        this.maxPassengers = maxPassengers;
        this.avgPassengers = avgPassengers;
        this.period = period;
    }

    /**
     * Gibt eine String-Repräsentation des Analyseergebnisses zurück.
     *
     * @return Eine formatierte String-Darstellung des Analyseergebnisses.
     */
    @Override
    public String toString() {
        return String.format("Zeitraum: %s%nKleinste Fahrgastanzahl: %d%nGrösste Fahrgastanzahl: %d%nDurchschnittliche Fahrgastanzahl: %.2f",
                period, minPassengers, maxPassengers, avgPassengers);
    }
}