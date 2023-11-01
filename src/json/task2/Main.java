package json.task2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) throws IOException {
        String jsonData = Files.readString(Path.of("Java/src/json/task2/test.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        ColourHandler colourHandler = objectMapper.readValue(jsonData, ColourHandler.class);
        colourHandler.colorizeText();
    }
}
