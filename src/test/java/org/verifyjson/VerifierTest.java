package org.verifyjson;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class VerifierTest {

    private final ArrayList<JsonNode> jsonFiles = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        for (int i = 1; i <= 6; i++) {
            jsonFiles.add(Reader.readJsonFromFile("input/sample" + i + ".json"));
        }
    }

    @org.junit.Test
    public void testVerifyJson1() throws IOException {
        Verifier verifier = new Verifier(jsonFiles.get(0));
        assertTrue(verifier.VerifyJson());
    }

    @org.junit.Test
    public void testVerifyJson2() throws IOException {
        Verifier verifier = new Verifier(jsonFiles.get(1));
        assertTrue(verifier.VerifyJson());
    }

    @org.junit.Test
    public void testVerifyJson3() throws IOException {
        Verifier verifier = new Verifier(jsonFiles.get(2));
        assertTrue(verifier.VerifyJson());
    }

    @org.junit.Test
    public void testVerifyJson4() throws IOException {
        Verifier verifier = new Verifier(jsonFiles.get(3));
        assertFalse(verifier.VerifyJson());
    }

    @org.junit.Test
    public void testVerifyJson5() throws IOException {
        Verifier verifier = new Verifier(jsonFiles.get(4));
        assertTrue(verifier.VerifyJson());
    }

    @org.junit.Test
    public void testVerifyJson6() throws IOException {
        Verifier verifier = new Verifier(jsonFiles.get(5));
        assertFalse(verifier.VerifyJson());
    }

    @org.junit.Test
    public void testVerifyJson7() throws IOException {
        try {
            Verifier verifier = new Verifier(null);
            fail("Expected an IOException to be thrown");
        } catch (IOException e) {
            assertEquals("JSON object is null", e.getMessage());
        }
    }

    @org.junit.Test
    public void testVerifyJson8() throws IOException {
        try {
            Verifier verifier = new Verifier(jsonFiles.get(0));
            verifier.VerifyJson();
            verifier.printJson();
        } catch (IOException e) {
            fail("Expected an IOException to be thrown");
        }
    }

    @org.junit.Test
    public void testVerifyJson9() throws IOException {
        try {
            Verifier verifier = new Verifier(jsonFiles.get(0));
            verifier.VerifyJson();
        } catch (IOException e) {
            fail("Expected an IOException to be thrown");
        }
    }


}