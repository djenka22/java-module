package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Reader {
    public static List<String> read(FileReader fileReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }
}
