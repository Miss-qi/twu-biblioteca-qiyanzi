package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;


public class Display {
    private PrintStream printStream;
    private BufferedReader reader;

    public Display(PrintStream printStream, BufferedReader reader) {
        this.printStream = printStream;
        this.reader = reader;
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome!");
    }

    public String getUserInput() {
        String userInput = "";
        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printStream.println();
        return userInput;
    }
}
