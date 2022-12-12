package com.epam.moduletesting;

import com.epam.moduletesting.io.FileDataPublisher;
import com.epam.moduletesting.io.FileDataReader;
import com.epam.moduletesting.template.TemplateEngine;
import com.epam.moduletesting.util.DataParser;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Facade {

    private final FileDataReader dataReader;
    private final FileDataPublisher dataPublisher;
    private final DataParser dataParser;
    private final Messenger messenger;
    private final TemplateEngine templateEngine;

    public void execute(boolean fileModeOn, String inputTemplateFile, String outputFile) {
        if (fileModeOn) {
            processViaFiles(inputTemplateFile, outputFile);
        } else {
            processViaConsole();
        }
    }

    private void processViaConsole() {
    }

    private void processViaFiles(String inputTemplateFile, String outputFile) {
    }
}
