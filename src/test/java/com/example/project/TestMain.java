package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import java.util.regex.*;
import java.io.*;

public class TestMain{
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }
    @BeforeEach
    public void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }
    @AfterEach
    public void tearDown() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
    @Test
    public void testPrintAnswer()
    {
        Riddle rid2 = new Riddle("What belongs to you, but is used by others?","Your name.");
        rid2.printAnswer();
        String actual = getOutput();
        assertEquals(actual, "Your name.\n", "Your printAnswer method needs to print the instance's answer.");
    }
    @Test
    public  void testPrintQuestion()
    {
        Riddle rid2 = new Riddle("What belongs to you, but is used by others?","Your name.");
        rid2.printQuestion();
        String actual = getOutput();
        assertEquals(actual, "What belongs to you, but is used by others?\n", "Your printQuestion method needs to print the instance's question.");
    }
}