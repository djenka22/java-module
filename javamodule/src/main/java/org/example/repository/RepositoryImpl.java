package org.example.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.contracts.Callback;
import org.example.factory.FileFactory;
import org.example.execute.Reader;
import org.example.execute.Writer;
import org.example.threads.ReadThread;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class RepositoryImpl implements org.example.contracts.Repository {
    private static RepositoryImpl instance;
    private final ExecutorService executorService;
    private RepositoryImpl() {
        executorService = Executors.newFixedThreadPool(4);
    }
    public static RepositoryImpl getInstance() {
        if(instance == null) {
            instance = new RepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<String> readLinesFromFile(File file) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FileFactory fileFactory = new FileFactory();
        Reader reader = new Reader();


        FileReader fileReader = (FileReader) fileFactory.generate(file, FileReader.class);
        return reader.read(fileReader);

    }
    @Override
    public void writeLinesToFile(List<String> lines, File file) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FileFactory fileFactory = new FileFactory();
        Writer writer = new Writer();
        FileWriter fileWriter = (FileWriter) fileFactory.generate(file, FileWriter.class);
        writer.write(fileWriter, lines);
        fileWriter.close();
    }
    @Override
    public void writeLinesToFile(Map<String, Integer> lines, File file) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FileFactory fileFactory = new FileFactory();
        Writer writer = new Writer();
        FileWriter fileWriter = (FileWriter) fileFactory.generate(file, FileWriter.class);
        writer.write(fileWriter, lines);
    }

    @Override

    public void returnLines(File file, Callback callback) {
        executorService.submit(new ReadThread(file, callback));
    }
}
