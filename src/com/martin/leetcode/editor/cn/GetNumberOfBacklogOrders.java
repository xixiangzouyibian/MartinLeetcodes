package com.martin.leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Martin Zhou on 2021/3/21
 */
public class GetNumberOfBacklogOrders {
    public static void main(String[] args) {
        System.out.println(new GetNumberOfBacklogOrders().getNumberOfBacklogOrders(new int[][] {{10,5,0},{15,2,1},{25,1,1},{30,4,0}}));
    }
    public int getNumberOfBacklogOrders(int[][] orders) {
        Queue<int[]> bp = new PriorityQueue<int[]>((o1, o2) -> o2[0] - o1[0]);
        Queue<int[]> sp = new PriorityQueue<int[]>((o1, o2) -> o1[0] - o2[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                bp.offer(new int[] {order[0], order[1]});
            } else if (order[2] == 1) {
                sp.offer(new int[] {order[0], order[1]});
            }

            while (!bp.isEmpty() && !sp.isEmpty() &&
                    bp.peek()[0] >= sp.peek()[0]) {
                int diff = bp.peek()[1] - sp.peek()[1];
                if (diff == 0) {
                    bp.poll();
                    sp.poll();
                } else if (diff > 0) {
                    int[] t = bp.poll();
                    if (!sp.isEmpty()) {
                        bp.offer(new int[] {t[0], t[1]-sp.peek()[1]});
                        sp.poll();
                    } else {
                        bp.offer(t);
                    }
                } else {
                    int[] t = sp.poll();
                    if (!bp.isEmpty()) {
                        sp.offer(new int[] {t[0], t[1]-bp.peek()[1]});
                        bp.poll();
                    } else {
                        sp.offer(t);
                    }
                }
            }
        }
        int res = 0;
        int MOD = 1000000007;
        while (!bp.isEmpty()) {
            res = (res + bp.poll()[1]) % MOD;
        }
        while (!sp.isEmpty()) {
            res = (res + sp.poll()[1]) % MOD;
        }
        return res;
    }
}
