package json.t;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Runner {
    static final String PATH = "json/t/test.json";

    public static void main(String[] args) throws Exception {
        byte[] json = ClassLoader.getSystemResourceAsStream(PATH).readAllBytes();
        ObjectMapper mapper = new ObjectMapper();

        ColourPicker colourPiсker = mapper.readValue(json, ColourPicker.class);
        colourPiсker.pick();

    }
}
