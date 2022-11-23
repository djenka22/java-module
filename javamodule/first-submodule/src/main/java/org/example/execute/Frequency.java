package org.example.execute;


import java.util.HashMap;
import java.util.Map;



public class Frequency {
    public static int findFrequency(String word, String line) {
        Map<Character, Integer> map = new HashMap<>();
        for(char character : word.toCharArray()) {
            map.put(character, 0);
        }

        int textLength = line.length();
        var brojac = 0;
        for(var i = 0; i < textLength; i++) {
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
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() < 1) {
                return false;
            }
            entry.setValue(entry.getValue() - 1);
        }
        return true;
    }
}
