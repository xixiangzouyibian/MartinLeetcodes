package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/2/28
 */
public class ClosestCost {
    public static void main(String[] args) {
        System.out.println(new ClosestCost().closestCost(new int[] {1,7}, new int[] {3,4}, 10));
        System.out.println(new ClosestCost().closestCost(new int[] {2,3}, new int[] {4,5,100}, 18));
        System.out.println(new ClosestCost().closestCost(new int[] {3,10}, new int[] {2,5}, 9));
        System.out.println(new ClosestCost().closestCost(new int[] {10}, new int[] {1}, 1));
    }

    int res = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int baseCost : baseCosts) {
            if (baseCost == target) {
                return baseCost;
            }
            dfs(toppingCosts, 0, toppingCosts.length, baseCost, target);
        }
        return res;
    }

    private void dfs(int[] toppingCosts, int start, int len, int cost, int target) { // given target, response value <= target
        int diff = Math.abs(target-cost) - Math.abs(target-res);
        if (diff < 0 || diff == 0 && cost < res) {
            res = cost;
        }
        if (cost >= target) {
            return;
        }
        for (int i = start; i < len; i++) {
            for (int j = 0; j < 3; j++) {
               dfs(toppingCosts, i+1, len, cost + toppingCosts[i] * j, target);
            }
        }
    }
}
