//有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。 
//
// 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。 
//
// 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。 
//
// 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：steps = 3, arrLen = 2
//输出：4
//解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
//向右，向左，不动
//不动，向右，向左
//向右，不动，向左
//不动，不动，不动
// 
//
// 示例 2： 
//
// 输入：steps = 2, arrLen = 4
//输出：2
//解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
//向右，向左
//不动，不动
// 
//
// 示例 3： 
//
// 输入：steps = 4, arrLen = 2
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= steps <= 500 
// 1 <= arrLen <= 10^6 
// 
// Related Topics 动态规划 
// 👍 150 👎 0


package com.martin.leetcode.editor.cn;


public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps{
    public static void main(String[] args) {
       Solution solution = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int mod = (int) (1e9 + 7);

        /**
         *      The right order:
         * 		i, j, dp[i][j]: 201
         * 		i, j, dp[i][j]: 211
         * 		i, j, dp[i][j]: 102
         * 		i, j, dp[i][j]: 112
         * 		i, j, dp[i][j]: 004
         * 		i, j, dp[i][j]: 014
         *
         *      The wrong order:
         * 		i, j, dp[i][j]: 201
         * 		i, j, dp[i][j]: 101
         * 		i, j, dp[i][j]: 001
         * 		i, j, dp[i][j]: 211
         * 		i, j, dp[i][j]: 112
         * 		i, j, dp[i][j]: 013
         *
         */
    public int numWays(int steps, int arrLen) {
        int max = Math.min(steps / 2, arrLen - 1);
        int[][] dp = new int[steps+1][max+1];
        dp[steps][0] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            for (int j = 0; j <= max; j++) {
                dp[i][j] = (dp[i][j] + dp[i+1][j]) % mod;
                if (j <= max -1 ) dp[i][j] = (dp[i][j] + dp[i+1][j+1]) % mod;
                if (j > 0) dp[i][j] = (dp[i][j] + dp[i+1][j-1]) % mod;
                System.out.println("i, j, dp[i][j]: " + i + j + dp[i][j]);
            }
        }
        return dp[0][0];
    }

/*    public int numWays(int steps, int arrLen) {
        int max = Math.min(steps / 2, arrLen - 1);
        int[][] dp = new int[steps+1][max+1];
        dp[steps][0] = 1;

        for (int i = steps - 1; i >= 0; i--) {
            int edge = Math.min(i, max);
            for (int j = 0; j <= edge; j++) {
                dp[i][j] = (dp[i][j] + dp[i+1][j]) % mod;
                if (j <= max -1 ) dp[i][j] = (dp[i][j] + dp[i+1][j+1]) % mod;
                if (j > 0) dp[i][j] = (dp[i][j] + dp[i+1][j-1]) % mod;
            }
        }
        return dp[0][0];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}
