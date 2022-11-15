package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.constants.ForbiddenCharacters.FORBIDDEN_CHARACTERS;


public class ValidatorTest {
    @Test
    public void itShouldThrowARuntimeException() {
        // given
        String word = "test123";
        Validator validator = new Validator(FORBIDDEN_CHARACTERS);

        // then
        Assertions.assertThrows(RuntimeException.class, () -> validator.validate(word));
    }
}
