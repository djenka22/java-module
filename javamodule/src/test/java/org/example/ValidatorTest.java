package org.example;

import org.example.errors.CustomError;
import org.junit.Assert;
import org.junit.Test;


public class ValidatorTest {
    @Test
    public void itShouldThrowARuntimeException() {
        // given
        String word = "test123.";
        Validator validator = new Validator("123.");

        // then
        Assert.assertThrows(CustomError.class, () -> validator.validate(word));
    }
}
