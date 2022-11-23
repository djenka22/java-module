package org.example.contracts;

import java.io.File;
import java.util.List;

public interface IService {
    List<String> readLinesFromFile(File file);
    void writeResultToFile(File file, List<String> lines, String word);
    void writeLinesToFile(File file, List<String> lines);


}
