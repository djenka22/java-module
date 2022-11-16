package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * Hello world!
 *
 */
@Slf4j
public class Main {
    static final String WORD = "BALLOON";
    static final String FILE_FOR_READ = "Balloon";
    static final String FILE_FOR_WRITE = "Result";

    public static void main( String[] args ) {
        var fileToRead = new File(FILE_FOR_READ);
        var fileToWrite = new File(FILE_FOR_WRITE);
        App app = new App(WORD);
        app.execute(fileToRead, fileToWrite);
    }




}
