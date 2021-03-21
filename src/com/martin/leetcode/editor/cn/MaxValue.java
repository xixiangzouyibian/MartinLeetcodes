package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/3/21
 */
public class MaxValue {
/*    public int maxValue(int n, int index, int maxSum) {
        int l = 1, r = maxSum-n+1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid-1, index, n, maxSum-n)) {
                l = mid;
            } else {
                r = mid-1;
            }
        }
        return l;
    }

    private boolean check(int val, int index, int n, int maxSum) {
        long left = Math.max(val-index, 1);
        long lSum = (left + val) * (val - left + 1) >> 1;

        long right = Math.max(val-(n-index-1), 1);
        long rSum = (right + val) * (val - right + 1) >> 1;

        return lSum + rSum - val <= maxSum;
    }*/

    public int maxValue(int n, int index, int maxSum) {
        int l = index, r = index;
        int budget = maxSum - n;
        int res = 1;
        while (l > 0 || r < n-1) {
            int len = r - l + 1;
            if (budget < len) break;

            res++;
            budget -= len;
            l = Math.max(l-1, 0);
            r = Math.min(r+1, n-1);
        }
        res += budget / n;
        return res;
    }
}
