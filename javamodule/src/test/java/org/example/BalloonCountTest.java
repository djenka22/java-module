package org.example;

import lombok.extern.slf4j.Slf4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;


//@ExtendWith(MockitoExtension.class)
@PrepareForTest(Frequency.class)
@RunWith(PowerMockRunner.class)
@Slf4j
public class BalloonCountTest {
    public Validator validator = mock(Validator.class);
    public Balloon underTest;

    @Before
    public void setUp() {
        underTest = new Balloon(validator);

    }
    @Test
    public void itShouldReturnMapOfLinesAndFrequenciesOfGivenWord() {
        // given
        String line = "BSKLLONOAUS";
        String word = "BALLOON";
        List<String> lines = List.of(line);

        PowerMockito.mockStatic(Frequency.class);
        Mockito.when(Frequency.findFrequency(word, line)).thenReturn(5);

        // when
        Map<String, Integer> actual = underTest.count(lines, word);

        // then
        PowerMockito.verifyStatic(Frequency.class);
        Frequency.findFrequency(word, line);

        HashMap<String,Integer> unExpected = new HashMap<>();
        unExpected.put(line, 1);
        Assert.assertNotEquals(unExpected, actual);
    }
    @Test
    public void canValidateWord() {
        underTest.count(List.of("BSKLLONOAUS"), "BALLOON");
        Mockito.verify(validator).validate("BALLOON");
    }
}
