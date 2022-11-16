package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.errors.CustomError;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class WriterGenerator {
    public static FileWriter generate(File file) {

        try {
            return new FileWriter(file);
        }  catch (IOException e) {
            log.info(e.getMessage());
            throw new CustomError("error generating FileWriter");
        }
    }
}
