package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/2/28
 */
public class MinOperations {
    public static void main(String[] args) {
        System.out.println(new MinOperations().minOperations(new int[] {1,1,1,1,1,1,1}, new int[] {6}));
    }

    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return minOperations(nums2, nums1);
        if (6 * m < n) return -1;

        int[] freq1 = new int[7];
        for (int j : nums1) freq1[j]++;

        int[] freq2 = new int[7];
        for (int j : nums2) freq2[j]++;

        int res = Integer.MAX_VALUE;
        for (int i = n; i <= 6 * m; i++) {
            res = Math.min(res, work(freq1, i) + work(freq2, i));
        }
        return res;
    }

    private int work(int[] freq, int target) {
        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += freq[i] * i;
        }
        if (sum > target) {
            int x = sum - target, res = 0;
            for (int j = 6; j > 1; j--) {
                int t = j-1;
                if (freq[j] * t >= x) return res + (x + t - 1) / t;
                res += freq[j];
                x -= freq[j] * t;
            }
            return res;
        } else {
            int x = target - sum, res = 0;
            for (int j = 1; j < 6; j++) {
                int t = 6 - j;
                if (freq[j] * t >= x) return res + (x + t - 1) / t;
                res += freq[j];
                x -= freq[j] * t;
            }
            return res;
        }
    }
}
