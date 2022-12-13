package com.epam.moduletesting;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class MailServerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final MailServer sut = new MailServer();

    @Test
    void shouldPrintOutMessage() {
        System.setOut(new PrintStream(outContent));
        String date = new Date(System.currentTimeMillis()).toString();
        sut.send("Client1", "How are you?");
        assertThat(outContent.toString(),
                is("Message: How are you?\nWas sent to: Client1\nWas sent at: " + date + "\r\n"));
    }
}
