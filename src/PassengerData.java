import com.fasterxml.jackson.annotation.JsonProperty;

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

    // Getter und Setter hier einfügen

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public Integer getCalendarWeek() {
        return calendarWeek;
    }

    public void setCalendarWeek(Integer calendarWeek) {
        this.calendarWeek = calendarWeek;
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    public String getMonthlyDate() {
        return monthlyDate;
    }

    public void setMonthlyDate(String monthlyDate) {
        this.monthlyDate = monthlyDate;
    }

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