package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/3/21
 */
public class MaxAscendingSum {
/*    public int maxAscendingSum(int[] nums) {
        int len = nums.length;
        if (len == 0) return nums[0];

        int res = 0;
        for (int i = 0; i < len; i++) {
            if (i+1 < len && nums[i+1] > nums[i]) {
                int sum = 0;
                while (i+1 < len && nums[i+1] > nums[i]) {
                    sum += nums[i++];
                }
                res = Math.max(res, sum+nums[i]);
            } else {
                res = Math.max(res, nums[i]);
            }
        }
        return res;
    }*/

    public int maxAscendingSum(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = nums[i] + dp[i-1];
            } else {
                dp[i] = nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
