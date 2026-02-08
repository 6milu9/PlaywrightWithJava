package framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

public class JsonDataReader {
    private JsonDataReader() {}

    public static Object[][] read(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> data =
                mapper.readValue(new File(path), List.class);

        Object[][] result = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i);
        }
        return result;
    }
}
