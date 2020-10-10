//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划 
// 👍 1235 👎 0

  
package com.martin.leetcode.editor.cn;
  
  
public class BestTimeToBuyAndSellStock{

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        System.out.println(solution.maxProfit(new int[] {7,1,5,3,6,4}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 0: profit, 1: hold
/*    public int maxProfit(int[] prices) {
        if (prices.length <=1) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(prices[i] - dp[i-1][1], 0); // the max profit at the i day
            dp[i][1] = Math.min(dp[i-1][1], prices[i]); // the least sock price if want to hold by i day
            if (max < dp[i][0]) max = dp[i][0];
        }
        return max;
    }*/

/*    public int maxProfit(int[] prices) {
        if (prices.length <=1) return 0;
        int least_hold_price = prices[0], max_profile = 0;

        for (int i = 1; i < prices.length; i++) {
            max_profile = Math.max(prices[i] - least_hold_price, max_profile);
            least_hold_price = Math.min(least_hold_price, prices[i]);
        }
        return max_profile;
    }*/

    public int maxProfit(int[] prices) {
        if (prices.length <=1) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}