package com.martin.leetcode.editor.cn.template;

/**
 * 思想是倍增
 */
public class QuickCal {
    /**
     * 快速乘
     * 快速幂原理相似
     */
    public static long mul(int a, int k) {
        int ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) ans += a;
            k >>= 1;
            a += a;
        }
        return ans;
    }

    /**
     * 快速除
     */
    public static long div(int a, int k) {
        if (a < k) return 0;

        int tmp = k;
        int count = 1;
        while (a >= tmp * tmp) {
            tmp = tmp + tmp;
            count = count + count;
        }
        return count + div(a - tmp, k);
    }

    public static void main(String[] args) {
        System.out.println(QuickCal.div(17, 3));
    }
}
