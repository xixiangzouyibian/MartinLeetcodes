package com.martin.leetcode.editor.cn;

import java.util.*;

/**
 * Created by Martin Zhou on 2021/3/28
 */
public class Evaluate {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }

        StringBuilder res = new StringBuilder();
        Deque<Character> queue = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length;) {
            if (chars[i] != '(') {
                res.append(chars[i++]);
            } else {
                StringBuilder builder = new StringBuilder();
                while (chars[++i] != ')') {
                    builder.append(chars[i]);
                }
                res.append(map.getOrDefault(builder.toString(), "?"));
                i++;
            }
        }
        return res.toString();
    }
}
