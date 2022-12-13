package com.epam.moduletesting.util;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.epam.moduletesting.Client;
import com.epam.moduletesting.template.Template;

public class DataParserTest {
    private static final String DATA = "I want to share #{item} with you\n"
            + "item=this\n"
            + "Client@gmail.com";

    private final DataParser sut = new DataParser();

    @Test
    void shouldParseTemplate() {
        HashMap<String, String> testMap = new HashMap<>();
        testMap.put("item", "this");
        Template expected = new Template("I want to share #{item} with you", testMap);

        Template actual = sut.parseData(Template.class, DATA);

        assertThat(actual, is(expected));
    }

    @Test
    void shouldParseClient() {
        Client expected = new Client("Client@gmail.com");

        Client actual = sut.parseData(Client.class, DATA);

        assertThat(actual, is(expected));
    }
}
