//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 727 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;

public class PartitionEqualSubsetSum{
    public static void main(String[] args) {
       Solution solution = new PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[] {1,2,3,5}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int n : nums) sum += n;
        if ((sum & 1) == 1) return false;

        return dfs(nums, 0, 0, 0, sum >> 1, new HashMap<>());
    }

    private boolean dfs(int[] nums, int start, int sum1, int sum2, int target, Map<String, Boolean> mem) {
        if (sum1 == target || sum2 == target) return true;
        if (sum1 > target || sum2 > target) return false;

        String key = sum1+"@"+sum2+"@"+start;
        if (mem.containsKey(key)) return mem.get(key);

        boolean res = dfs(nums, start + 1, sum1, sum2 + nums[start], target, mem) ||
                dfs(nums, start + 1, sum1 + nums[start], sum2, target, mem);
        mem.put(key, res);

        return res;
    }*/


/*    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int n : nums) sum += n;
        if ((sum & 1) == 1) return false;

        int target = sum >> 1;
        int len = nums.length;
        boolean[][] dp = new boolean[len][target+1];

        dp[0][0] = true;
        for (int i = 1; i < len; i++) {
            dp[i][0] = true;
            for (int j = 0; j <= target; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
            if (dp[i][target]) return true;
        }

        return dp[len-1][target];
    }*/

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int n : nums) sum += n;
        if ((sum & 1) == 1) return false;

        int target = sum >> 1;
        int len = nums.length;
        boolean[] dp = new boolean[target+1];

        dp[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
