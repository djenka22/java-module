package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class Writer {
    public static void write(FileWriter writer, Map<String, Integer> map) throws IOException {
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue().toString() + "\n");
            log.info("text to write: {}: {}", entry.getKey(), entry.getValue());
        }
    }
}
