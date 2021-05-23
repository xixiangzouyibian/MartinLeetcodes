package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/5/23
 */
public class CheckZeroOnes {

    public static void main(String[] args) {
        System.out.println(new CheckZeroOnes().checkZeroOnes("111000"));
    }

    public boolean checkZeroOnes(String s) {
        int len = s.length();
        char[] cc = s.toCharArray();

        int num0 = 0;
        int num1 = 0;
        for (int i = 0; i < len;) {
            int index = i;
            if (cc[i] == '0') {
                while (index < len && cc[index] == '0') index++;
                num0 = Math.max(num0, index - i);
            } else {
                while (index < len && cc[index] == '1') index++;
                num1 = Math.max(num1, index - i);
            }
            i = index;
        }

        return num1 > num0;
    }
}
