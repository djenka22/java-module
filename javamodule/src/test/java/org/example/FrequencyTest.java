package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class FrequencyTest {
    @Test
    public void itShouldReturnFrequencyOfTheWordAppearingInString() {
        // given
        String line = "BSKLLONOAUS";
        String word = "BALLOON";


        // when
        int underTest = Frequency.findFrequency(word, line);

        // then
        Assertions.assertEquals(underTest, 1);
    }
}
