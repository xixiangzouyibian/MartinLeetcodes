package com.martin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Created by Martin Zhou on 2021/3/6
 */
public class BeautySum {

    public static void main(String[] args) {
        System.out.println(new BeautySum().beautySum("aabcb"));
    }

    public int beautySum(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        int res = 0;
        for (int i = 0; i < len; i++) {
            Arrays.fill(map, 0);
            for (int j = i; j < len; j++) {
                map[chars[j]-'a']++;
                int max = 0, min = 500;
                for (int k = 0; k < 26; k++) {
                    if (map[k] > 0) {
                        max = Math.max(max, map[k]);
                        min = Math.min(min, map[k]);
                    }
                }
                res += max - min;
            }
        }
        return res;
    }

}
