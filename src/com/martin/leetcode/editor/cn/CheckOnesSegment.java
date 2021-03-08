package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/3/7
 */
public class CheckOnesSegment {
    public boolean checkOnesSegment(String s) {
        int len = s.length();
        if (len == 1) return true;

        char[] chars = s.toCharArray();
        int start = 1;
        while (start < len && chars[start] == '1') {
            start++;
        }
        for (int i = start; i < len; i++) {
            if (chars[i] == '1') return false;
        }
        return true;
    }
}
