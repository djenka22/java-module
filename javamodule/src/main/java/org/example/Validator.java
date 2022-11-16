package org.example;

import org.example.errors.CustomError;

import java.util.HashMap;
import java.util.Map;



public class Validator {
    private Map<Character, String> map;
    private String forbiddenCharacters;

    public Validator(String forbiddenCharacters) {
        this.forbiddenCharacters = forbiddenCharacters;
        this.map = fillMap();
    }

    private Map<Character, String> fillMap() {
        map = new HashMap<>();
        for (char ch : forbiddenCharacters.toCharArray()) {
            map.put(ch, null);
        }
        return map;
    }

    public void validate(String word) {
        for(char ch : word.toCharArray()) {
            if(Character.isDigit(ch)) {
                throw new CustomError("Word must not have digits!");
            }
            if(map.containsKey(ch)) {
                throw new CustomError("Word must not have" + forbiddenCharacters + "characters!");
            }
        }
    }
}
