package org.example;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class Balloon {
    private Validator validator;

    public Balloon(@Nullable Validator validator) {
        this.validator = validator;
    }

    public Map<String, Integer> count(List<String> lines, String word) {
        if (validator != null) {
            validator.validate(word);
        }
        Map<String, Integer> map = new HashMap<>();
        for(String line : lines) {
            map.put(line, Frequency.findFrequency(word, line));
        }
        return map;
    }

    /*
    static int balloon(String s) {

        int duzina = s.length();

        int brojac = 0;
        int niz[] = new int[5];
        if (s.length() < 7) {
            return 0;
        }
        for(int i = 0; i < duzina; i++) {
            if (s.charAt(i) == 'B') {
                niz[0]++;
            }
            if (s.charAt(i) == 'A') {
                niz[1]++;
            }
            if (s.charAt(i) == 'L') {
                niz[2]++;
            }
            if (s.charAt(i) == 'O') {
                niz[3]++;
            }
            if (s.charAt(i) == 'N') {
                niz[4]++;
            }
            if (niz[0] >= 1 && niz[1] >= 1 && niz[2] >= 2 && niz[3] >= 2 && niz[4] >= 1) {
                brojac++;
                niz[0]--;
                niz[1]--;
                niz[2] -= 2;
                niz[3] -= 2;
                niz[4]--;
            }
        }
        return brojac;
    }

    */
}
