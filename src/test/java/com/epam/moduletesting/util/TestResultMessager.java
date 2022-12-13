package com.epam.moduletesting.util;

import org.junit.jupiter.api.extension.ExtensionContext;

public class TestResultMessager {
    public String createResultMessage(ExtensionContext context) {
        return context.getDisplayName() + " has the following tags " + context.getTags()
                + ". During execution throws exceptions: " + context.getExecutionException().isPresent()
                + ". Executed in " + context.getExecutionMode() + " mode\n";
    }
}

