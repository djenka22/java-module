package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.List;
import java.util.Map;

import static org.example.constants.ForbiddenCharacters.FORBIDDEN_CHARACTERS;

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
            Balloon balloon = new Balloon(new Validator(FORBIDDEN_CHARACTERS));
            Map map = balloon.count(lines, WORD);
            Writer.write(fileWriter, map);
            fileReader.close();
            fileWriter.close();
        } catch (IOException | RuntimeException e) {
            log.info(e.getMessage());
        }
    }
}
