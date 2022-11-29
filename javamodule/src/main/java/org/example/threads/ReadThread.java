package org.example.threads;

import lombok.SneakyThrows;
import org.example.contracts.Callback;
import org.example.execute.Reader;
import org.example.factory.FileFactory;

import java.io.File;
import java.io.FileReader;

public class ReadThread implements Runnable {
    private final File file;
    private final Callback callback;

    public ReadThread(File file, Callback callback) {
        this.file = file;
        this.callback = callback;
    }

    @SneakyThrows
    @Override
    public void run() {
        Reader reader = new Reader();
        FileReader fileReader = (FileReader) FileFactory.generate(file, FileReader.class);
        callback.onResultReadingLines(reader.read(fileReader));
    }

}
