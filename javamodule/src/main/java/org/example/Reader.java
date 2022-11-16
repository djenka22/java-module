package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class Reader {
    public static List<String> read(FileReader fileReader) throws IOException {
        var bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }
}
