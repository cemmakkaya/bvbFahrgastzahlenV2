import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Diese Klasse repräsentiert die Fahrgastdaten für einen bestimmten Zeitpunkt oder Zeitraum.
 * Sie wird verwendet, um Daten aus der JSON-Datei zu deserialisieren und zu speichern.
 *
 */
public class PassengerData {
    @JsonProperty("startdatum_kalenderwoche_monat")
    private String startDate;

    @JsonProperty("fahrgaeste_einsteiger")
    private int passengers;

    @JsonProperty("kalenderwoche")
    private Integer calendarWeek;

    @JsonProperty("granularitat")
    private String granularity;

    @JsonProperty("datum_der_monatswerte")
    private String monthlyDate;

    /**
     * Gibt das Startdatum zurück.
     * @return Das Startdatum als String.
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Gibt die Anzahl der Fahrgäste zurück.
     * @return Die Anzahl der Fahrgäste als int.
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Gibt die Kalenderwoche zurück.
     * @return Die Kalenderwoche als Integer, oder null wenn nicht verfügbar.
     */
    public Integer getCalendarWeek() {
        return calendarWeek;
    }

    /**
     * Gibt die Granularität der Daten zurück.
     * @return Die Granularität als String.
     */
    public String getGranularity() {
        return granularity;
    }

    /**
     * Gibt das Datum der Monatswerte zurück.
     * @return Das Datum der Monatswerte als String, oder null wenn nicht verfügbar.
     */
    public String getMonthlyDate() {
        return monthlyDate;
    }

    /**
     * Gibt eine String-Repräsentation des PassengerData-Objekts zurück.
     * Diese Methode ist nützlich für Debugging-Zwecke.
     *
     * @return Eine String-Repräsentation des Objekts.
     */
    @Override
    public String toString() {
        return "PassengerData{" +
                "startDate='" + startDate + '\'' +
                ", passengers=" + passengers +
                ", calendarWeek=" + calendarWeek +
                ", granularity='" + granularity + '\'' +
                ", monthlyDate='" + monthlyDate + '\'' +
                '}';
    }
}