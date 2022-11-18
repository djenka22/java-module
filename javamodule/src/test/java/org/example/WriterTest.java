package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.contracts.IWriter;
import org.example.execute.Writer;
import org.junit.*;
import org.mockito.Mockito;


import java.io.*;
import java.util.List;
import java.util.Map;

@Slf4j
public class WriterTest {
    public FileReader fileReader;
    public FileWriter fileWriter;

    @Before
    public void setUp() throws IOException {
        fileReader = Mockito.mock(FileReader.class);
        fileWriter = Mockito.mock(FileWriter.class);
    }
    @Test
    public void itShouldCallFileWriterWriteAndSendCorrectParameter() throws IOException {
        // given
        IWriter writer = new org.example.execute.Writer();
        Map<String, Integer> input = Map.of("test", 0);

        // when
        writer.write(fileWriter, input);

        // then
        Mockito.verify(fileWriter).write("test: 0\n");
    }
    @Test
    public void itShouldCallFileWriterWriteAndSendCorrectParameterList() throws IOException {
        // given
        org.example.execute.Writer writer = new Writer();
        List<String> input = List.of("test1", "test2");

        // when
        writer.write(fileWriter, input);

        // then
        Mockito.verify(fileWriter).write("test1");
        Mockito.verify(fileWriter).write("test2");
    }
}
