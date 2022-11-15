package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.constants.ForbiddenCharacters.FORBIDDEN_CHARACTERS;


public class BalloonCountTest {
    @Test
    public void itShouldReturnMapOfLinesAndFrequenciesOfGivenWord() {
        // given
        String line = "BSKLLONOAUS";
        String word = "BALLOON";
        List<String> lines = List.of(line);
        Balloon balloon = new Balloon(new Validator(FORBIDDEN_CHARACTERS));

        // when
        Map<String,Integer> underTest = balloon.count(lines, word);

        // then
        HashMap<String,Integer> expected = new HashMap<>();
        expected.put(line, 1);
        Assertions.assertEquals(underTest, expected);
    }
}
