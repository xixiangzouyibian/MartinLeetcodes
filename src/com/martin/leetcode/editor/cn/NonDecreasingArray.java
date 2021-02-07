//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。 
//
// 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
// 
//
// 示例 2: 
//
// 输入: nums = [4,2,1]
//输出: false
//解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
// 
//
// 
//
// 说明： 
//
// 
// 1 <= n <= 10 ^ 4 
// - 10 ^ 5 <= nums[i] <= 10 ^ 5 
// 
// Related Topics 数组 
// 👍 417 👎 0


package com.martin.leetcode.editor.cn;


public class NonDecreasingArray{
    public static void main(String[] args) {
       Solution solution = new NonDecreasingArray().new Solution();
        System.out.println(solution.checkPossibility(new int[] {4,2,1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int[] numsCopy = new int[len+2];
        numsCopy[0] = Integer.MIN_VALUE;
        numsCopy[len+1] = Integer.MAX_VALUE;
        System.arraycopy(nums,0,numsCopy,1,len);

        int start = 1;
        int count = 0;
        while (start <= len) {
            if (numsCopy[start-1] > numsCopy[start]) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (numsCopy[start-1] > numsCopy[start+1] && numsCopy[start-2] > numsCopy[start]) {
                    return false;
                }
            }
            start++;
        }

        return true;
    }*/

    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if (n <= 2) return true;
        int down = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                down++;
                if (down > 1) {
                    return false;
                }
                if (i > 1 && i < n - 1 && nums[i - 1] > nums[i + 1] && nums[i - 2] > nums[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
