package org.example.contracts;

import java.io.IOException;
import java.util.List;

public interface Callback {
    void onResultReadingLines(List<String> linesToRead) throws IOException;
}
