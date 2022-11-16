package org.example;

import junit.framework.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Map;

@Slf4j
public class WriterTest {
    public final String KEY = "BAOOLLNNOLOLGBAXBALLOONKSKSKSBALLOONAHJAHUAFDASIOFBALLOONJASFIJBOKSDFAFJKDJLIDFLJDFNODFHDOJFDSIJEQFNBALLOON";
    public final Integer VALUE = 7;
    public final String FILE_NAME = "Writer-test";
    public File file;

    @BeforeEach
    public void setUp() throws IOException {
        file = new File(FILE_NAME);
        file.createNewFile();
    }
    @AfterEach
    public void tearDown() {
        file.delete();
    }
    @Test
    public void itShouldWriteCorrectText() throws IOException {
        // given
        Map<String, Integer> map = Map.of(KEY, VALUE);

        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter(file);
        BufferedReader bf = new BufferedReader(reader);

        // when
        Writer.write(writer, map);
        writer.close();

        //then
        String actual = bf.readLine();
        reader.close();
        String expected = KEY + ": " + VALUE;
        Assert.assertEquals(expected, actual);
    }
}
