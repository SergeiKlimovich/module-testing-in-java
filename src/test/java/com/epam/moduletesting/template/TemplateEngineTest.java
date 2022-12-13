package com.epam.moduletesting.template;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.epam.moduletesting.BusinessLogicTest;
import com.epam.moduletesting.Client;
import com.epam.moduletesting.exception.WrongDataException;

@BusinessLogicTest
class TemplateEngineTest {

    private final TemplateEngine sut = new TemplateEngine();

    @ParameterizedTest
    @MethodSource("generateNonExceptionalTestCases")
    void shouldGenerateMessageWhenValidDataPassed(String expectedResult, Template template, Client client) {
        String actual = sut.generateMessage(template, client);

        assertThat(actual, is(expectedResult));
    }

    @Test
    void shouldThrowInsufficientDataExceptionWhenNotAllSubsPresent() {
        Template template = new Template("Template 1 has #{value}", Collections.emptyMap());
        Client client = new Client("Address1");

        assertThrows(WrongDataException.class, () -> sut.generateMessage(template, client));
    }

    private static Stream<Arguments> generateNonExceptionalTestCases() {
        HashMap<String, String> testMap1 = new HashMap<String, String>();
        testMap1.put("value", "SubstitutedValue");
        HashMap<String, String> testMap2 = new HashMap<String, String>();
        testMap2.put("value", "SubstitutedValue1");
        testMap2.put("value2", "#{tag}");
        HashMap<String, String> testMap3 = new HashMap<String, String>();
        testMap3.put("value", "SubstitutedValue3");
        testMap3.put("value2", "WillNotBePresent");

        return Stream.of(Arguments.of("Template 1 has SubstitutedValue. Sent to Address1",
                        new Template("Template 1 has #{value}",
                                testMap1), new Client("Address1")),
                Arguments.of("Template 2 has SubstitutedValue1 and #{tag}. Sent to Address2",
                        new Template("Template 2 has #{value} and #{value2}",
                                testMap2),
                        new Client("Address2")),
                Arguments.of("Template 3 has SubstitutedValue3. Sent to Address3",
                        new Template("Template 3 has #{value}",
                                testMap3),
                        new Client("Address3")));
    }
}