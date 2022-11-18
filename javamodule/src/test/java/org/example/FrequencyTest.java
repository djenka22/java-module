package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.execute.Frequency;
import org.junit.Assert;
import org.junit.Test;


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
        Assert.assertEquals(underTest, 1);
    }
}
