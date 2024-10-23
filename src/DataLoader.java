import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Diese Klasse ist verantwortlich für das Laden von Fahrgastdaten aus einer JSON-Datei.
 * Sie verwendet Jackson für die JSON-Deserialisierung.
 *
 * @author Cem Akkaya & Daniel Fluri
 * @version 2.0
 */
public class DataLoader {
    private String fileName;

    /**
     * Konstruktor für den DataLoader.
     *
     * @param fileName Der Name (oder Pfad) der zu ladenden JSON-Datei.
     */
    public DataLoader(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Lädt die Fahrgastdaten aus der spezifizierten JSON-Datei.
     *
     * @return Eine Liste von PassengerData-Objekten, oder null im Falle eines Fehlers.
     */
    public List<PassengerData> loadData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<PassengerData> data = mapper.readValue(new File(fileName), new TypeReference<List<PassengerData>>(){});
            if (data == null || data.isEmpty()) {
                System.err.println("Warnung: Keine Daten geladen oder leere Datei.");
            }
            return data;
        } catch (IOException e) {
            System.err.println("Fehler beim Laden der Daten: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}