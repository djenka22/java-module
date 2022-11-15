package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
@Slf4j
public class AppTest {
    @Test
    public void itShouldCheckIfAppDoesNotThrowAnException() {
        // given
        String line = "BAOOLLNNOLOLGBAXBALLOONKSKSKSBALLOONAHJAHUAFDASIOFBALLOONJASFIJBOKSDFAFJKDJLIDFLJDFNODFHDOJFDSIJEQFNBALLOON";
        String word = "BALLOON";

        // creating new files
        File fileForRead = new File("Read-Test");
        File fileForWrite = new File("Write-Test");

        // writing line into file for reading
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter(fileForRead);
            fileWriter.write(line);
        } catch (IOException e) {
            log.error("Error while testing App");
            log.error(e.getMessage());
        }
        Assertions.assertNotNull(fileWriter);

        // then
        App app = new App(word);
        Assertions.assertDoesNotThrow(() -> app.execute(fileForRead, fileForWrite));

        fileForRead.delete();
        fileForWrite.delete();
    }


}
