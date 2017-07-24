package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class DisplayTest {
    private Display display;
    private PrintStream printStream;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        display = new Display(printStream, reader);
    }

    @Test
    public void shouldDisplayWelcomeMessage() {
        display.displayWelcomeMessage();
        verify(printStream).println("Welcome!");
    }

    @Test
    public void shouldReturnUserInput() throws IOException {
        when(reader.readLine()).thenReturn("1");
        assertThat(display.getUserInput(), is("1"));
    }
}
