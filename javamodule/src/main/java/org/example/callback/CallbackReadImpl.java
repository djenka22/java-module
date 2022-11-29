package org.example.callback;

import org.example.contracts.Callback;

import java.io.IOException;
import java.util.List;

public class CallbackReadImpl implements Callback {
    @Override
    public void onResultReadingLines(List<String> linesToRead) throws IOException {
        System.out.println(linesToRead);
    }
}
