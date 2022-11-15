package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class WordFrequencyTest {
    @Test
    public void itShouldReturnWordFrequency() {
        // given
        String line = "BSKLLONOAUS";
        String word = "BALLOON";
        List<String> lines = List.of(line);

        // when
        Map<String,Integer> underTest = Balloon.count(lines, word);

        // then
        HashMap<String,Integer> expected = new HashMap<>();
        expected.put(line, 1);
        Assertions.assertEquals(underTest, expected);
    }
}
