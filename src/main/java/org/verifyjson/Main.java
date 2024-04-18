package org.verifyjson;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java -jar verifyjson.jar <json_file>");
            System.exit(1);
        }

        JsonNode json = Reader.readJsonFromFile(args[0]);
        Verifier verifier = new Verifier(json);
        boolean result = verifier.VerifyJson();
        System.out.println(result ? "Json is valid" : "Json is not valid");
    }
}