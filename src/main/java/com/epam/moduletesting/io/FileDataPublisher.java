package com.epam.moduletesting.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.epam.moduletesting.exception.WrongPathException;

public class FileDataPublisher {

    public void publishData(String filePath, String data) {
        try {
            File outputFile = new File(filePath);
            FileUtils.writeStringToFile(outputFile, data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new WrongPathException("Could not to resolve the path: " + filePath);
        }
    }
}
