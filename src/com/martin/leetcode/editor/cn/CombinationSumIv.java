//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
// Related Topics 动态规划 
// 👍 381 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class CombinationSumIv{
    public static void main(String[] args) {
       Solution solution = new CombinationSumIv().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int combinationSum4(int[] nums, int target) {
        int len = target;
        int[][] dp = new int[len+1][target+1];

        dp[0][0] = 1;
        int res = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                for (int n : nums) {
                    if (j - n >= 0) dp[i][j] += dp[i-1][j-n];
                }
            }
            res += dp[i][target];
        }
        return res;
    }*/

/*    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];

        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int n : nums) {
                if (j >= n) dp[j] += dp[j-n];
            }
        }
        return dp[target];
    }*/

    public int combinationSum4(int[] nums, int target) {
        return dfs(nums, target, new HashMap<>());
    }

    private int dfs(int[] nums, int target, Map<Integer, Integer> map) {
        if (target == 0) return 1;

        if (map.containsKey(target)) return map.get(target);

        int res = 0;
        for (int n : nums) {
            if (target >= n) {
                res += dfs(nums, target-n, map);
            }
        }
        map.put(target, res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
