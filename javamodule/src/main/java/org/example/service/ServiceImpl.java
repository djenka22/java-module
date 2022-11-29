package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.contracts.Callback;
import org.example.contracts.Repository;
import org.example.execute.Balloon;
import org.example.repository.RepositoryImpl;

import java.io.File;
import java.util.List;
import java.util.Map;

@Slf4j
public class ServiceImpl implements org.example.contracts.Service {
    private static ServiceImpl instance;
    private final Repository repository;
    private ServiceImpl() {
        this.repository = RepositoryImpl.getInstance();
    }
    public static ServiceImpl getInstance() {
        if(instance == null) {
            instance = new ServiceImpl();
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

    @Override
    public void writeLinesToFile(File file, List<String> lines) {
        try {
            repository.writeLinesToFile(lines, file);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    public void readLines(File file, Callback callback) {
        repository.returnLines(file, callback);
    }


}
