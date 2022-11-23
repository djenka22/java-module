package org.example.execute;

import lombok.extern.slf4j.Slf4j;
import org.example.contracts.IReader;
import org.example.contracts.IWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
public class Writer implements IWriter {
    @Override
    public void write(FileWriter writer, Map<String, Integer> map) throws IOException {
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue().toString() + "\n");
            log.info("text to write: {}: {}", entry.getKey(), entry.getValue());
        }
    }
    @Override
    public void write(FileWriter writer, List<String> lines) throws IOException {
        for(String s : lines) {
            writer.write(s);
        }
    }
}
