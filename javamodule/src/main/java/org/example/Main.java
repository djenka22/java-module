package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
        File fileToRead = new File(FILE_FOR_READ);
        File fileToWrite = new File(FILE_FOR_WRITE);
        App app = new App(WORD);
        app.execute(fileToRead, fileToWrite);
    }




}
