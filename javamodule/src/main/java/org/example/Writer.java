package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class Writer {
    public static void write(FileWriter writer, Map<String, Integer> map) throws IOException {
        for(String s : map.keySet()) {
            writer.write(s + ": " + map.get(s) + "\n");
            log.info("text to write: {}: {}", s, map.get(s));
        }
    }
}
