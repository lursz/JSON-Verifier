package org.verifyjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Reader {

    public static JsonNode readJsonFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

//        JsonNode jsonNode = objectMapper.readTree(new File(filePath));
//        return jsonNode;

        try {
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));
            return jsonNode;
        } catch (IOException e) {
            throw new IOException("Issue with file" + filePath + ": " + e.getMessage());
        }
    }
}
