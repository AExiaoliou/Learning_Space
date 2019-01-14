package com.aexiaoliou.algorithm;

import org.jetbrains.annotations.NotNull;
import java.util.HashMap;

public class Sunday {
    private String pattern;
    private HashMap<Character, Integer> shift = new HashMap<>();

    public Sunday(@NotNull String pattern) {
        this.pattern = pattern;
        for (int i = 0; i < pattern.length(); i++) {
            shift.put(pattern.charAt(i), pattern.length() - i);
        }
    }

    public int search(String mainStr) {
        String s = mainStr;
        int len = pattern.length();
        for (int i = 0, j = 0; i < mainStr.length(); ) {
            if (s.charAt(j) != pattern.charAt(i)) {
                j = j - i; i = 0;
                j += shift.getOrDefault(s.charAt(j + len), len + 1);
            } else {
                i++; j++;
                if (i == len) return j - i;
            }
        }
        return -1;
    }
}
