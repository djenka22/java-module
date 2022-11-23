package org.example;

import lombok.extern.slf4j.Slf4j;

import org.example.contracts.IValidator;
import org.example.execute.Balloon;
import org.example.execute.Frequency;
import org.example.execute.Validator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import java.util.List;
import static org.mockito.Mockito.mock;


@PrepareForTest(Frequency.class)
@RunWith(PowerMockRunner.class)
@Slf4j
public class BalloonCountTest {
    public IValidator validator;
    public Balloon underTest;

    @Before
    public void setUp() {
        validator = mock(Validator.class);
        underTest = new Balloon(validator);
        log.info("mocking {}", validator.getClass());
        log.info("instancing {}", underTest.getClass());
    }
    @Test
    public void canFindFrequencyWhenCountIsCalled() {
        // given
        String line = "BSKLLONOAUS";
        String word = "BALLOON";
        List<String> lines = List.of(line);

        PowerMockito.mockStatic(Frequency.class);
        //Mockito.when(Frequency.findFrequency(word, line)).thenReturn(5);

        // when
        underTest.count(lines, word);

        // then
        PowerMockito.verifyStatic(Frequency.class);
        Frequency.findFrequency(word, line);

    }
    @Test
    public void canValidateWord() {
        // when
        underTest.count(List.of("BSKLLONOAUS"), "BALLOON");
        // then
        Mockito.verify(validator).validate("BALLOON");
    }
}
