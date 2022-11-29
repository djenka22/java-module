package org.example.contracts;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface Repository {
    List<String> readLinesFromFile(File file) throws Exception;
    void writeLinesToFile(List<String> lines, File file) throws Exception;
    void writeLinesToFile(Map<String, Integer> lines, File file) throws Exception;
    void returnLines(File file, Callback callback);
}
