package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/3/14
 */
public class AreAlmostEqual {
/*    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int s2L = s2.length();
        for (int i = 0; i < s1.length(); i++) {
            if (i >= s2L) count++;
            if (s1.charAt(i) != s2.charAt(i)) count++;
            if (count > 2) return false;
        }
        return true;
    }*/

    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int n = s1.length();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
                count++;
            }
            if (count > 2) return false;
        }
        return sb1.reverse().toString().equals(sb2.toString());
    }
}
