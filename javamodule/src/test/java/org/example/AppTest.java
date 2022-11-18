package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.mock;

@PrepareForTest({FileFactory.class, WriterGenerator.class, Reader.class, Writer.class})
@RunWith(PowerMockRunner.class)
@Slf4j
public class AppTest {

    public Balloon ballon = mock(Balloon.class);
    public File fileForRead;
    public File fileForWrite;
    public FileReader fileReader;
    public FileWriter fileWriter;
    @Before
    public void setUp() throws IOException {
        fileForRead = new File("Read-Test");

        fileForWrite = new File("Write-Test");
       // fileReader = new FileReader(fileForRead);
        //fileWriter = new FileWriter(fileForWrite);
    }
    @After
    public void tearDown() {
        fileForRead.delete();
        fileForWrite.delete();
    }
    @Test
    public void itShouldCheckIfAppDoesNotThrowAnException() throws IOException {
        // given
      /*  String line = "BAOOLLNNOLOLGBAXBALLOONKSKSKSBALLOONAHJAHUAFDASIOFBALLOONJASFIJBOKSDFAFJKDJLIDFLJDFNODFHDOJFDSIJEQFNBALLOON";
        String word = "BALLOON";
        PowerMockito.mockStatic(FileFactory.class);
        //Mockito.when(FileFactory.generate(null)).thenReturn(null);
        PowerMockito.mockStatic(Reader.class);
        //Mockito.when(Reader.read(null)).then();
        PowerMockito.mockStatic(WriterGenerator.class);
        Mockito.when(WriterGenerator.generate(fileForWrite)).thenReturn(fileWriter);
        PowerMockito.mockStatic(Writer.class);
        App app = new App(word);
        app.execute(fileForRead, fileForWrite);
        PowerMockito.verifyStatic(FileFactory.class);
        //ReaderGenerator.generate(fileForRead);
        PowerMockito.verifyStatic(WriterGenerator.class);
        WriterGenerator.generate(fileForWrite);
        PowerMockito.verifyStatic(Reader.class);
        Reader.read(fileReader);
        Mockito.verify(ballon).count(List.of(line), word);
        PowerMockito.verifyStatic(Writer.class);
        Writer.write(fileWriter, new HashMap<>());
        // creating new files

        // writing line into file for reading

        // then

        //Assert.assertFalse(() -> app.execute(fileForRead, fileForWrite));


       */

    }


}
