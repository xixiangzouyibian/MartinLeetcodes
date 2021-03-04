//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 1081 👎 0

  
package com.martin.leetcode.editor.cn;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence{

    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
//        System.out.println(solution.binSearch(new int[]{2, 5}, 3, 1));
        System.out.println(solution.lengthOfLIS(new int[] {10,9,2,5,3,4}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int[] dp = new int[len];
        int res = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            if (list.isEmpty() || list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int index = Collections.binarySearch(list, num);
                list.set(index < 0 ? -index - 1 : index, num);
            }
        }
        return list.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}