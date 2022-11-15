package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class ReaderGenerator {
    public static FileReader generate(File file) {

        try {
            return new FileReader(file);
        }  catch (IOException e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}