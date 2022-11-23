package org.example;

import org.example.contracts.IReader;
import org.example.execute.Reader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.io.BufferedReader;
import java.io.FileReader;


@PrepareForTest({BufferedReader.class, Reader.class})
@RunWith(PowerMockRunner.class)
public class ReaderTest {
    FileReader fileReader;
    BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        fileReader = PowerMockito.mock(FileReader.class);
        bufferedReader = PowerMockito.mock(BufferedReader.class);

        PowerMockito
                .whenNew(BufferedReader.class)
                .withArguments(fileReader)
                .thenReturn(bufferedReader);
    }

    @Test
    public void canCallBufferedReaderConstructorWithCorrectParameter() throws Exception {
        // given
        IReader reader = new Reader();

        // when
        reader.read(fileReader);

        // then
        PowerMockito.verifyNew(BufferedReader.class).withArguments(fileReader);

    }
}