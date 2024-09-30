import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DataAnalyzer {
    private List<PassengerData> data;

    public DataAnalyzer(List<PassengerData> data) {
        this.data = data;
    }

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

    private List<PassengerData> filterByPeriod(String period) {
        return data.stream()
                .filter(d -> matchesPeriod(d, period))
                .collect(Collectors.toList());
    }

    private boolean matchesPeriod(PassengerData d, String period) {
        LocalDate date = LocalDate.parse(d.getStartDate(), DateTimeFormatter.ISO_DATE);

        if (period.matches("\\d{4}")) { // Jahr
            return date.getYear() == Integer.parseInt(period);
        } else if (period.matches("\\d{4}-Q[1-4]")) { // Jahreszeit (Quartal)
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

    private int getMinPassengers(List<PassengerData> filteredData) {
        return filteredData.stream()
                .mapToInt(PassengerData::getPassengers)
                .min()
                .orElse(0);
    }

    private int getMaxPassengers(List<PassengerData> filteredData) {
        return filteredData.stream()
                .mapToInt(PassengerData::getPassengers)
                .max()
                .orElse(0);
    }

    private double getAveragePassengers(List<PassengerData> filteredData) {
        return filteredData.stream()
                .mapToInt(PassengerData::getPassengers)
                .average()
                .orElse(0);
    }
}

class AnalysisResult {
    private final int minPassengers;
    private final int maxPassengers;
    private final double avgPassengers;
    private final String period;

    public AnalysisResult(int minPassengers, int maxPassengers, double avgPassengers, String period) {
        this.minPassengers = minPassengers;
        this.maxPassengers = maxPassengers;
        this.avgPassengers = avgPassengers;
        this.period = period;
    }

    @Override
    public String toString() {
        return String.format("Zeitraum: %s%nKleinste Fahrgastanzahl: %d%nGrösste Fahrgastanzahl: %d%nDurchschnittliche Fahrgastanzahl: %.2f",
                period, minPassengers, maxPassengers, avgPassengers);
    }
}