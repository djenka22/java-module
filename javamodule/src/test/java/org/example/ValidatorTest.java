package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class ValidatorTest {
    @Test
    public void itShouldThrowARuntimeException() {
        // given
        String word = "test123.";
        Validator validator = new Validator("123.");

        // then
        Assertions.assertThrows(RuntimeException.class, () -> validator.validate(word));
    }
}
