package org.example.execute;

import lombok.extern.slf4j.Slf4j;
import org.example.contracts.IReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class Reader implements IReader {
    @Override
    public List<String> read(FileReader fileReader) throws IOException {
        var bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> lines = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }
}
