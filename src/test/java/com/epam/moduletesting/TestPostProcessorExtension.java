package com.epam.moduletesting;

import java.io.File;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.epam.moduletesting.util.TestResultMessager;

public class TestPostProcessorExtension implements AfterTestExecutionCallback {

    public static final String EXECUTION_FILE = "src/test/resources/testResults.txt";
    private final TestResultMessager testResultMessager = new TestResultMessager();

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        File file = new File(EXECUTION_FILE);
        FileUtils.writeStringToFile(file, testResultMessager.createResultMessage(context), StandardCharsets.UTF_8,
                true);
    }
}
