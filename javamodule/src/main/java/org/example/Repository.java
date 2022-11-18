package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.errors.CustomError;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@Slf4j
public class Repository {
    private static Repository instance;
    private Repository() { }
    public static Repository getInstance() {
        if(instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public List<String> readLinesFromFile(File file) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FileFactory fileFactory = new FileFactory();
        Reader reader = new Reader();

        FileReader fileReader = (FileReader) fileFactory.generate(file, FileReader.class);
        return reader.read(fileReader);

    }
    public void writeLinesToFile(List<String> lines, File file) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FileFactory fileFactory = new FileFactory();
        Writer writer = new Writer();
        FileWriter fileWriter = (FileWriter) fileFactory.generate(file, FileWriter.class);
        writer.write(fileWriter, lines);
    }
    public void writeLinesToFile(Map<String, Integer> lines, File file) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FileFactory fileFactory = new FileFactory();
        Writer writer = new Writer();
        FileWriter fileWriter = (FileWriter) fileFactory.generate(file, FileWriter.class);
        writer.write(fileWriter, lines);
    }
}
