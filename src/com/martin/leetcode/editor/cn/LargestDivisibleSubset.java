//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 109 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数学 动态规划 
// 👍 310 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset{
    public static void main(String[] args) {
       Solution solution = new LargestDivisibleSubset().new Solution();
        System.out.println(solution.largestDivisibleSubset(new int[] {4,8,10,240}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[len];
        int[] index = new int[len];
        Arrays.fill(index, -1);

        int max = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        index[i] = j;
                        max = Math.max(max, dp[i]);
                    }
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (dp[i] == max) {
                List<Integer> res = new ArrayList<>();
                while (i != -1) {
                    res.add(nums[i]);
                    i = index[i];
                }
                return res;
            }
        }

        return new ArrayList<>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
