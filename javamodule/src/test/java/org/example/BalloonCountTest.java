package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.constants.ForbiddenCharacters.FORBIDDEN_CHARACTERS;


@ExtendWith(MockitoExtension.class)
public class BalloonCountTest {
    @Mock
    public Validator validator;
    public Balloon underTest;

    @BeforeEach
    public void setUp() {
        underTest = new Balloon(validator);

    }
    @Test
    public void itShouldReturnMapOfLinesAndFrequenciesOfGivenWord() {
        // given
        String line = "BSKLLONOAUS";
        String word = "BALLOON";
        List<String> lines = List.of(line);

        // when
        Map<String,Integer> actual = underTest.count(lines, word);

        // then
        HashMap<String,Integer> expected = new HashMap<>();
        expected.put(line, 1);
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void canValidateWord() {
        underTest.count(List.of("BSKLLONOAUS"), "BALLOON");
        Mockito.verify(validator).validate("BALLOON");
    }
}
