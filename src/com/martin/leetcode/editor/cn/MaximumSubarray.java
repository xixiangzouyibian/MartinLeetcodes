  //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2495 👎 0

  
  package com.martin.leetcode.editor.cn;


  public class MaximumSubarray{
  
      public static void main(String[] args) {
           Solution solution = new MaximumSubarray().new Solution();
      }
      
      
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i+1] = Math.max(dp[i], 0) + nums[i];
            if (max < dp[i+1]) {
                max = dp[i+1];
            }
        }
        return max;
    }*/
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum, 0) + nums[i];
            if (max < sum) max = sum;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }