package com.martin.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Martin Zhou on 2021/3/14
 */
public class MaxAverageRatio {
    public static void main(String[] args) {
        System.out.println(new MaxAverageRatio().maxAverageRatio(new int[][] {{1,2},{3,5},{2,2}}, 2));
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<>(Comparator.comparingDouble(v -> -v[2]));
        double sum = 0;
        for (int[] c : classes) {
            sum +=  (double) c[0] / c[1];
            queue.offer(new double[] {c[0], c[1], diff(c[0], c[1])});
        }

        while (extraStudents-- > 0) {
            double[] cur = queue.poll();
            sum += cur[2];
            queue.offer(new double[] {cur[0]+1, cur[1]+1, diff(cur[0]+1, cur[1]+1)});
        }

        return sum / classes.length;
    }

    private double diff(double x, double y) {
        return (x + 1) / (y + 1) - x / y;
    }
}
