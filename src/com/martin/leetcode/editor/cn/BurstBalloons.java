//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics 分治算法 动态规划 
// 👍 678 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;

public class BurstBalloons{
    public static void main(String[] args) {
       Solution solution = new BurstBalloons().new Solution();
        System.out.println(solution.maxCoins(new int[] {3,1,5,8}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] nn = new int[len+2];
        Arrays.fill(nn, 1);
        System.arraycopy(nums,0,nn,1,len);

        int[][] dp = new int[len+2][len+2];
        for (int p = 3; p <= len+2; p++) {
            for (int i = 0; i <= len+2-p; i++) {
                int j = i+p-1;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nn[i] * nn[k] * nn[j]);
                }
            }
        }
        return dp[0][len+1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
