package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/3/28
 */
public class MaxNiceDivisors {

    public static void main(String[] args) {
//        BigDecimal decimal = new BigDecimal(3);
//        System.out.println(new BigDecimal(3).pow(333333332).remainder(new BigDecimal(1000000007)).intValue());
        System.out.println(new MaxNiceDivisors().maxNiceDivisors(73));
    }
    int MOD = 1_000_000_007;
    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 3) return primeFactors;
        int a = primeFactors / 3;
        int b = primeFactors % 3;

        if (b == 0) return (int) calPow(3, a, MOD);
        else if (b == 1) return (int) (4 * calPow(3, a-1, MOD) % MOD);
        else return (int) (2 * calPow(3, a, MOD) % MOD);
    }

    private long calPow(int x, int y, int mod) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            y /= 2;
        }
        return res;
    }
}
