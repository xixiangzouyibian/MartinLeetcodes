  //给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 231 - 1 
// 
// Related Topics 动态规划 
// 👍 850 👎 0

  
  package com.martin.leetcode.editor.cn;


  import java.util.*;
  import java.util.stream.Collectors;

  public class CoinChange{
  
      public static void main(String[] args) {
           Solution solution = new CoinChange().new Solution();
           int[] coins = {1,2,5};
          System.out.println(solution.coinChange(coins, 11));
      }
      
      
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*          int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        find(coins, amount, count);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void find(int[] coins, int amount, int count) {
        if (amount <= 0) {
            if (amount == 0 && min > count) {
                min = count;
            }
            return;
        }
        for (int item : coins) {
            find(coins, amount - item, count+1);
        }
    }*/

/*    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i-coin] != -1 && min > dp[i-coin]) {
                    min = dp[i-coin];
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }
        return dp[amount];
    }*/

          //BFS
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount+1];
        queue.offer(amount);
        visited[amount] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int head = queue.poll();
                for (int coin : coins) {
                    int amountChange = head - coin;
                    if (amountChange == 0) {
                        return count;
                    }
                    if (amountChange < 0) {
                        continue;
                    }
                    if (!visited[amountChange]) {
                        queue.offer(amountChange);
                        visited[amountChange] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }