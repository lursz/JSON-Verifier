package org.verifyjson;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonNode json = Reader.readJsonFromFile("input/sample.json");
        Verifier verifier = new Verifier(json);
        boolean result = verifier.VerifyJson();

    }
}