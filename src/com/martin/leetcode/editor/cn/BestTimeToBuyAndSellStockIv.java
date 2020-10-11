//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
// 
//
// 示例 2: 
//
// 输入: [3,2,6,5,0,3], k = 2
//输出: 7
//解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。
// 
// Related Topics 动态规划 
// 👍 314 👎 0

  
package com.martin.leetcode.editor.cn;
  
  
public class BestTimeToBuyAndSellStockIv{

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k < 1 ) { return 0; }

        // k 超过了上限，也就变成了 无限次交易问题
        if (k > prices.length / 2) {
            return maxProfitOfII(prices);
        }
        // 状态定义
        int [][] dp = new int[k][2];

        // 初始化
        for (int i = 0; i < k; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        // 遍历每一天，模拟 k 次交易，计算并更新状态
        for (int p : prices) {
            dp[0][0] = Math.max(dp[0][0], 0 - p);                  // 第 1 次买
            dp[0][1] = Math.max(dp[0][1], dp[0][0] + p);           // 第 1 次卖
            for (int i = 1; i < k; i++) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] - p);   // 第 i 次买
                dp[i][1] = Math.max(dp[i][1], dp[i][0] + p);       // 第 i 次卖
            }
        }
        return dp[k - 1][1];
    }

    // 解决无限次交易的方法
    public int maxProfitOfII(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}