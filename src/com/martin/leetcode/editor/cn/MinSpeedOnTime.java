package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/5/23
 */
public class MinSpeedOnTime {

    public static void main(String[] args) {
        System.out.println(new MinSpeedOnTime().minSpeedOnTime(new int[] {1,1,10000}, 2.01));
//        System.out.println(new MinSpeedOnTime().minSpeedOnTime(new int[] {1,3,2}, 2.7));
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 10000005;

        while (l < r) {
            int mid = l + r >> 1;
            if (check(dist, hour, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r == 10000005 ? -1 : r;
    }

    public boolean check(int[] dist, double hour, int speed) {
        int len = dist.length;
        double sum = 0;
        for (int i = 0; i < len - 1; i++) {
//            sum += Math.ceil((double) dist[i] / speed);
            sum += (dist[i] + speed - 1) / speed;
        }
        sum += (double) dist[len-1] / speed;
        return sum <= hour;
    }
}
