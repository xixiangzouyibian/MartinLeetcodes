//还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴
//都要用到。 
//
// 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。 
//
// 示例 1: 
//
// 
//输入: [1,1,2,2,2]
//输出: true
//
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: [3,3,3,3,4]
//输出: false
//
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 注意: 
//
// 
// 给定的火柴长度和在 0 到 10^9之间。 
// 火柴数组的长度不超过15。 
// 
// Related Topics 深度优先搜索 
// 👍 161 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;

public class MatchsticksToSquare{
    public static void main(String[] args) {
       Solution solution = new MatchsticksToSquare().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean makesquare(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum == 0 || sum % 4 != 0) return false;
        Arrays.sort(nums);
        return dfs(nums, len, len-1, sum / 4, new int[4]);
    }

    private boolean dfs(int[] nums, int len, int start, int target, int[] size) {
        if (start == -1) {
            return size[0] == size[1] && size[1] == size[2] && size[2] == size[3];
        }

        for (int i = 0; i < 4; i++) {
            if (size[i] + nums[start] > target || i > 0 && size[i] == size[i-1]) {
                continue;
            }
            size[i] += nums[start];
            if (dfs(nums, len, start-1, target, size)) {
                return true;
            }
            size[i] -= nums[start];
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
