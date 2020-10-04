  //给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 778 👎 0

  
  package com.martin.leetcode.editor.cn;
  
  
  public class MaximumProductSubarray{
  
      public static void main(String[] args) {
           Solution solution = new MaximumProductSubarray().new Solution();
      }
      
      
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*          public int maxProduct(int[] nums) {
              int[][] dp = new int[nums.length][2]; // [][0] is min, [][1] is max
              dp[0][1] = dp[0][0] = nums[0];
              int max = nums[0];
              for (int i = 1; i < nums.length; i++) {
                  if (nums[i] < 0) {
                      dp[i][1] = Math.max(dp[i-1][0] * nums[i], nums[i]);
                      dp[i][0] = Math.min(dp[i-1][1] * nums[i], nums[i]);
                  } else {
                      dp[i][1] = Math.max(dp[i-1][1] * nums[i], nums[i]);
                      dp[i][0] = Math.min(dp[i-1][0] * nums[i], nums[i]);
                  }

                  if (max < dp[i][1]) max = dp[i][1];
              }
              return max;
          }*/

          public int maxProduct(int[] nums) {
              int cur_max = 1, cur_min = 1, max = Integer.MIN_VALUE;
              for (int i = 0; i < nums.length; i++) {
                  if (nums[i] < 0) {
                      int tmp = cur_max;
                      cur_max = cur_min;
                      cur_min = tmp;
                  }
                  cur_max = Math.max(cur_max * nums[i], nums[i]);
                  cur_min = Math.min(cur_min * nums[i], nums[i]);
                  max = Math.max(max, cur_max);
              }
              return max;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }