package org.example.contracts;

import java.util.List;
import java.util.Map;

public interface IBalloon {
    Map<String, Integer> count(List<String> lines, String word);
}
