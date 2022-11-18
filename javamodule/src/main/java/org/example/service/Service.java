package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.execute.Balloon;
import org.example.repository.Repository;
import org.example.contracts.IService;

import java.io.File;
import java.util.List;
import java.util.Map;

@Slf4j
public class Service implements IService {
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

    @Override
    public List<String> readLinesFromFile(File file) {
        try {
            return repository.readLinesFromFile(file);
        } catch (Exception e) {
           log.error(e.getMessage());
           throw new RuntimeException(e.getMessage());
        }
    }
    @Override
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
