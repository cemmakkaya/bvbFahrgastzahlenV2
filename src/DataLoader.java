import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataLoader {
    private String fileName;

    public DataLoader(String fileName) {
        this.fileName = fileName;
    }

    public List<PassengerData> loadData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(fileName), new TypeReference<List<PassengerData>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}