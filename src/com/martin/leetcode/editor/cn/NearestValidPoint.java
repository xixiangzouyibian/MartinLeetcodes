package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/3/6
 */
public class NearestValidPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int dis = 100001;
        int res = -1;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            int[] cur = points[i];
            if (cur[0] == x || cur[1] == y) {
                int curDis = Math.abs(cur[0]-x) + Math.abs(cur[1]-y);
                if (curDis < dis) {
                    dis = curDis;
                    res = i;
                }
            }
        }
        return res;
    }
}
