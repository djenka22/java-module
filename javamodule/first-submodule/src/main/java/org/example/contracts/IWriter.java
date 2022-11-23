package org.example.contracts;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IWriter {
    void write(FileWriter writer, Map<String, Integer> map) throws IOException;
    void write(FileWriter writer, List<String> lines) throws IOException;
}
