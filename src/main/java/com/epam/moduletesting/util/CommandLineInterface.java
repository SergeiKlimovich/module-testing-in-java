package com.epam.moduletesting.util;

import com.epam.moduletesting.Facade;
import com.epam.moduletesting.MailServer;
import com.epam.moduletesting.Messenger;
import com.epam.moduletesting.io.FileDataPublisher;
import com.epam.moduletesting.io.FileDataReader;
import com.epam.moduletesting.template.TemplateEngine;

import picocli.CommandLine;

@CommandLine.Command(name = "messenger",
        description = "The entity pretends to send emails using a custom template generator")


public class CommandLineInterface implements Runnable {
    @CommandLine.Option(names = "-enableFileMode")
    private boolean fileModeOn;
    @CommandLine.Option(names = "-inputTemplate")
    private String inputTemplate;
    @CommandLine.Option(names = "outputFile")
    private String outputFile;

    @Override
    public void run() {
        FileDataReader fileDataReader = new FileDataReader();
        FileDataPublisher fileDataPublisher = new FileDataPublisher();
        TemplateEngine templateEngine = new TemplateEngine();
        MailServer mailServer = new MailServer();
        Messenger messenger = new Messenger(mailServer, templateEngine);
        DataParser dataParser = new DataParser();
        Facade facade = new Facade(fileDataReader, fileDataPublisher, dataParser, messenger, templateEngine);
        facade.execute(fileModeOn, inputTemplate, outputFile);
    }
}
