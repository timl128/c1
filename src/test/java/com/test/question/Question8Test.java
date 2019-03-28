package com.test.question;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import static com.test.question.Question.getHtmlContent;
import static org.junit.Assert.*;

public class Question8Test {

    private Question8 question8;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setup(){
        question8 = new Question8();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void runWithOne() {

        String content = "Blah blah blah <a href='https://www.google.com/'>JavaCodeGeeks</a> blah blah blah blah";
        question8.run(content);
        assertEquals("https://www.google.com/\n", outContent.toString());
    }

    @Test
    public void runWithTwo() {

        String content = "Blah blah blah <a href='https://www.google.com/'>JavaCodeGeeks</a> blah blah blah blah"
            + "Blah blah blah <a HREF='https://stackoverflow.com/'>JavaCodeGeeks</a> blah blah blah blah";
        question8.run(content);
        assertEquals("https://www.google.com/\nhttps://stackoverflow.com/\n", outContent.toString());
    }

    @Test
    public void runWithUrl() {

        String content =  getHtmlContent("https://www.news.com.au/");
        question8.run(content);
  //      assertEquals(false, outContent.toString().isEmpty());
    }



}