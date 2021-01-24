//给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。 
//
// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那
//么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,5,4,7]
//输出：3
//解释：最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2]
//输出：1
//解释：最长连续递增序列是 [2], 长度为1。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 数组 
// 👍 147 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousIncreasingSubsequence{
    public static void main(String[] args) {
       Solution solution = new LongestContinuousIncreasingSubsequence().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int l = 0, r = 0;
        int max = 0;
        while (r < len) {
            while (r+1 < len && nums[r+1] > nums[r]) {
                r++;
            }
            max = Math.max(max, r - l +1);
            r++;
            l = r;
        }
        return max;
    }*/

    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;

        Deque<Integer> stack = new ArrayDeque<>(len);
        stack.offer(0);
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[stack.peekLast()]) {
                max = Math.max(max, stack.size());
                stack.clear();
            }
            stack.offer(i);
        }
        return Math.max(max, stack.size());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
