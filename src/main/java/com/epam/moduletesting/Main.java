package com.epam.moduletesting;

import com.epam.moduletesting.util.CommandLineInterface;

import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        CommandLine.run(new CommandLineInterface(), args);
    }
}
