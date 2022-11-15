package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;



public class Frequency {
    public static int findFrequency(String word, String line) {
        Map<Character, Integer> map = new HashMap<>();
        for(char character : word.toCharArray()) {
            map.put(character, 0);
        }

        int textLength = line.length();
        int brojac = 0;
        for(int i = 0; i < textLength; i++) {
            if (map.containsKey(line.charAt(i))) {
                int num = map.get(line.charAt(i));
                map.put(line.charAt(i), ++num);
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
}
