package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Balloon {
    static Map<String, String> count(List<String> lines, String word) {
        Map<String, String> map = new HashMap<>();
        for(String line : lines) {
            map.put(line, frequency(word, line) + "");
        }
        return map;
    }
    static int frequency(String word, String text) {
        validateWord(word);
        Map<Character, Integer> map = new HashMap<>();
        for(char character : word.toCharArray()) {
            map.put(character, 0);
        }

        int textLength = text.length();
        int brojac = 0;
        for(int i = 0; i < textLength; i++) {
            if (map.containsKey(text.charAt(i))) {
                log.info("map contains key {}", text.charAt(i));
                int num = map.get(text.charAt(i));
                map.put(text.charAt(i), ++num);
            }
        }

        while(checkNums(map)) {
            brojac++;
        }
        return brojac;
    }
    private static boolean checkNums(Map<Character, Integer> map) {
        for(Character key : map.keySet()) {
            if(map.get(key) < 1) {
                return false;
            }
            int num = map.get(key);
            map.put(key, --num);
        }
        return true;
    }
    private static void validateWord(String word) {
        for(char ch : word.toCharArray()) {
            if (Character.isDigit(ch)) {
                throw new RuntimeException("Word must not have digits!");
            }
        }
    }

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
}
