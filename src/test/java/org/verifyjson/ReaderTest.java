package org.verifyjson;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;

import java.io.IOException;

import static org.junit.Assert.*;

public class ReaderTest {

    @Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void testReadJsonFromFileNotNull() throws IOException {
        JsonNode json = Reader.readJsonFromFile("input/sample1.json");
        assertNotNull(json);
    }

    @org.junit.Test
    public void testReadJsonFromFileNull() {
        try {
            JsonNode json = Reader.readJsonFromFile("nonexist/nonexist.json");
            fail("Expected an IOException to be thrown");
        } catch (IOException e) {
            assertEquals("nonexist/nonexist.json (No such file or directory)", e.getMessage());
        }
    }

    @org.junit.Test
    public void testReadJsonFromFileEmpty() {
        try {
            JsonNode json = Reader.readJsonFromFile("");
            fail("Expected an IOException to be thrown");
        } catch (IOException e) {
            assertEquals(" (No such file or directory)", e.getMessage());
        }
    }

    @org.junit.Test
    public void testReadJsonFromFile() throws IOException {
            JsonNode json = Reader.readJsonFromFile("input/sample1.json");
            String jsonText = "{\"PolicyName\":\"root\",\"PolicyDocument\":{\"Version\":\"2012-10-17\",\"Statement\":[{\"Sid\":\"IamListAccess\",\"Effect\":\"Allow\",\"Action\":[\"iam:ListRoles\",\"iam:ListUsers\"],\"Resource\":\"*\"}]}}";
            assertEquals(jsonText, json.toString());


    }
}