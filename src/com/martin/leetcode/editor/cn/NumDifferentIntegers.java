package com.martin.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Martin Zhou on 2021/3/28
 */
public class NumDifferentIntegers {

    public static void main(String[] args) {
        System.out.println(new NumDifferentIntegers().numDifferentIntegers("leet1234code234"));
    }

    public int numDifferentIntegers(String word) {
        Set<Long> set = new HashSet<>();
        char[] chars = word.toCharArray();
        long num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                if (num != 0) set.add(num);
                if (i > 0 && chars[i-1] == '0' && num == 0) set.add((long) 0);
                num = 0;
            } else {
                if (chars[i] == '0' && num == 0) continue;
                num = num * 10 + (chars[i] - '0');
            }
        }
        if (num != 0) set.add(num);

        return set.size();
    }
}
