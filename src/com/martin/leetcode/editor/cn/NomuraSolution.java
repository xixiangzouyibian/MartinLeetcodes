package com.martin.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Created by Martin Zhou on 2021/1/5
 */
public class NomuraSolution {
    public static void main(String[] args) {
//        System.out.println(new NomuraSolution().solution(new int[] {6,10,6,9,7,8}));
        System.out.println(new NomuraSolution().solution(new int[] {6,9,9,10,10,11}));
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int maxLen = 0;
        int start = 0;
        while (start < A.length) {
            int count = 1;
            int compareNum = A[start];
            while (start+1 < A.length && (compareNum == A[start+1] || compareNum+1 == A[start+1])) {
                start++;
                count++;
            }
            if (compareNum == A[start]) {
                start++;
            }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen <= 1 ? 0 : maxLen;
    }
}
