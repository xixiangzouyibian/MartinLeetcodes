//给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。 
//
// 示例 1： 
//
// 输入：[1,0,1,1,0]
//输出：4
//解释：翻转第一个 0 可以得到最长的连续 1。
//     当翻转以后，最大连续 1 的个数为 4。
// 
//
// 
//
// 注： 
//
// 
// 输入数组只包含 0 和 1. 
// 输入数组的长度为正整数，且不超过 10,000 
// 
//
// 
//
// 进阶： 
//如果输入的数字是作为 无限流 逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？ 
// Related Topics 双指针 
// 👍 49 👎 0


package com.martin.leetcode.editor.cn;


public class MaxConsecutiveOnesIi{
    public static void main(String[] args) {
       Solution solution = new MaxConsecutiveOnesIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int l = 0, r = 0;
        int max = 0;
        int k = 1;
        int count1 = 0;
        while (r < len) {
            if (nums[r] == 1) {
                count1++;
            }
            while (nums[r] == 0 && count1 + k < r-l+1) {
                if (nums[l] == 1) {
                    count1--;
                }
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }*/

/*    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int l = 0, r = 0;
        int max = 0;
        int count0 = 0;
        while (r < len) {
            if (nums[r] == 0) {
                count0++;
            }
            while (count0 > 1) {
                if (nums[l] == 0) {
                    count0--;
                }
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }*/

    public int findMaxConsecutiveOnes(int[] nums) {
        int dp0 = 0, dp1 = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                dp0 += 1;
                dp1 += 1;
            } else {
                dp1 = dp0 + 1;
                dp0 = 0;
            }
            max = Math.max(dp0, max);
            max = Math.max(dp1, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
