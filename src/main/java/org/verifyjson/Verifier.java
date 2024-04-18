package org.verifyjson;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class Verifier {
    private final JsonNode _json;

    public Verifier(JsonNode json) throws IOException {
        if (json == null) {
            throw new IOException("JSON object is null");
        }
        this._json = json;
    }

    public boolean VerifyJson() throws IOException {
        try {
            JsonNode statements = this._json.get("PolicyDocument").get("Statement");

            if (statements != null) {
                for (JsonNode statement : statements) {
                    JsonNode resourceNode = statement.get("Resource");
                    if (resourceNode != null && resourceNode.asText().contains("*")) {
                        return true;
                    }
                }
            }
            return false;
        } catch (NullPointerException e) {
            throw new IOException("Issue with JSON object: " + e.getMessage());
        }
    }

    public void printJson() {
        System.out.println("JSON Object: " + this._json);
    }
}



