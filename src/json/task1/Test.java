package json.task1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("Java/src/json/task1/test1.json");
        String jsonData = Files.readString(path);
        ObjectMapper objectMapper = new ObjectMapper();
        Tester tester = objectMapper.readValue(jsonData, Tester.class);
        System.out.println(tester);
    }
}
