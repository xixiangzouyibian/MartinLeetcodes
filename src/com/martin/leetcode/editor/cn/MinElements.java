package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/3/7
 */
public class MinElements {
    public static void main(String[] args) {
        double a = 8.4;
        System.out.println((int) a);
        System.out.println((int) 8.6);
    }
    public int minElements(int[] nums, int limit, int goal) {
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double diff = goal - sum;
        if (diff == 0) return 0;
        return (int) (Math.abs(diff) % limit == 0.0 ? Math.abs(diff) / limit : Math.abs(diff) / limit + 1);
    }
}
