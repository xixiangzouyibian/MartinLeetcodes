package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/3/6
 */
public class CheckPowersOfThree {
    public static void main(String[] args) {
        System.out.println(new CheckPowersOfThree().checkPowersOfThree(21));
        System.out.println(new CheckPowersOfThree().checkPowersOfThree(12));
        System.out.println(new CheckPowersOfThree().checkPowersOfThree(91));
    }
    public boolean checkPowersOfThree(int n) {
        int count = 0;
        int temp = 1;
        while (temp * 3 <= n) {
            temp *= 3;
            count++;
        }
        return dfs(count, 0,0, n);
    }

    private boolean dfs(int count, int start, int num, int n) {
        if (num == n) {
            return true;
        }
        if (num > n) {
            return false;
        }
        for (int i = start; i <= count; i++) {
            if (dfs(count, i+1, (int) (num + Math.pow(3, i)), n)) {
                return true;
            }
        }
        return false;
    }
}
