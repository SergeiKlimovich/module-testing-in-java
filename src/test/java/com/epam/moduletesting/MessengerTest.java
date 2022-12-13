package com.epam.moduletesting;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.moduletesting.template.Template;
import com.epam.moduletesting.template.TemplateEngine;

@ExtendWith(MockitoExtension.class)
@ExtendWith(TestPostProcessorExtension.class)
public class MessengerTest {
    @Mock
    private MailServer mailServer;
    @Mock
    private TemplateEngine templateEngine;
    @InjectMocks
    private Messenger sut;

    @TestFactory
    Stream<DynamicTest> generateTestCases() {
        HashMap<String, String> testMap = new HashMap<>();
        testMap.put("value", "SubstitutedValue");

        return Stream.of(DynamicTest.dynamicTest("shouldGetGeneratedMessageAndSendIt1",
                        () -> {
                            when(templateEngine.generateMessage(any(Template.class), any(Client.class))).thenReturn(
                                    "Generated messaged 1");
                            doCallRealMethod().when(mailServer).send("Client1Address", "Generated messaged 1");
                            sut.sendMessage(new Client("Client1Address"),
                                    new Template("Template1", Collections.emptyMap()));
                            verify(mailServer, times(1))
                                    .send("Client1Address", "Generated messaged 1");
                        }),
                DynamicTest.dynamicTest("shouldGetGeneratedMessageAndSendIt2",
                        () -> {
                            when(templateEngine.generateMessage(any(), any())).thenCallRealMethod();
                            doNothing().when(mailServer).send(eq("Address1"), anyString());

                            sut.sendMessage(new Client("Address1"), new Template("Template 1 has #{value}",
                                    testMap));

                            verify(templateEngine, times(1)).generateMessage(new Template("Template 1 has #{value}",
                                    testMap), new Client("Address1"));
                        }));
    }

}
