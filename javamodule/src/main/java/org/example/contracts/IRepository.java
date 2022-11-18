package org.example.contracts;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface IRepository {
    List<String> readLinesFromFile(File file) throws Exception;
    void writeLinesToFile(List<String> lines, File file) throws Exception;
    void writeLinesToFile(Map<String, Integer> lines, File file) throws Exception;
}
