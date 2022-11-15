package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.List;
import java.util.Map;

@Slf4j
public class App {
    private final String WORD;
    public App( String word) {
        WORD = word;
    }
    public void execute(File fileToRead, File fileToWrite) {

        try {
            FileReader fileReader = ReaderGenerator.generate(fileToRead);
            FileWriter fileWriter = WriterGenerator.generate(fileToWrite);
            List<String> lines = Reader.read(fileReader);
            Map map = Balloon.count(lines, WORD);
            Writer.write(fileWriter, map);
            fileReader.close();
            fileWriter.close();
        } catch (IOException | RuntimeException e) {
            log.info(e.getMessage());
        }
    }
}
