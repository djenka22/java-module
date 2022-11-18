package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;
import java.util.Map;

@Slf4j
public class Service {
    private static Service instance;
    private final Repository repository;
    private Service() {
        this.repository = Repository.getInstance();
    }
    public static Service getInstance() {
        if(instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public List<String> readLinesFromFile(File file) {
        try {
            return repository.readLinesFromFile(file);
        } catch (Exception e) {
           log.error(e.getMessage());
           throw new RuntimeException(e.getMessage());
        }
    }
    public void writeResultToFile(File file, List<String> lines, String word) {
        Balloon balloon = new Balloon(null);
        Map<String, Integer> result = balloon.count(lines, word);
        try {
            repository.writeLinesToFile(result, file);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
