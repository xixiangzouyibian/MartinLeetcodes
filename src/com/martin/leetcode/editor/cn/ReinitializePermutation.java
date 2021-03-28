package com.martin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Martin Zhou on 2021/3/28
 */
public class ReinitializePermutation {

    public static void main(String[] args) {
        System.out.println(new ReinitializePermutation().reinitializePermutation(6));
    }

    public int reinitializePermutation(int n) {
        int res = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nIndex;
            if (i % 2 == 0) {
                nIndex = i / 2;
            } else {
                nIndex = n / 2 + (i-1) / 2;
            }
            if (nIndex != i) {
                map.put(i, nIndex);
            }
        }

        int count = 0;
        for (Integer k : map.keySet()) {
            int start = k;
            while (map.get(start) != k) {
                start = map.get(start);
                count++;
            }
            break;
        }

        return count + res;
    }
}
