package org.example.contracts;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IReader {
    List<String> read(FileReader fileReader) throws IOException;
}
