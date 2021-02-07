//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
// 0。 
//
// 
//
// 示例： 
//
// 输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 546 👎 0


package com.martin.leetcode.editor.cn;


public class MinimumSizeSubarraySum{
    public static void main(String[] args) {
       Solution solution = new MinimumSizeSubarraySum().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int min = len+1;
        int l = 0, r = 0;
        int sum = 0;
        while (r < len) {
            sum += nums[r];
            while (sum >= target) {
                min = Math.min(min, r-l+1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return min == len+1 ? 0 : min;
    }*/

/*    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] sum = new int[len+1];
        for (int i = 0; i < len; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        int min = len+1;
        for (int i = 1; i <=len; i++) {
            if (sum[i] >= target) {
                int pre = find(sum, 0, i, sum[i]-target);
                min = Math.min(min, i-pre);
            }
        }
        return min == len+1 ? 0 : min;
    }

    private int find(int[] sum, int l, int r, int target) {
        while (l < r) {
            int mid = (l+r+1) >> 1;
            if (sum[mid] == target) {
                return mid;
            } else if (sum[mid] > target) {
                r = mid-1;
            } else {
                l = mid;
            }
        }
        return l;
    }*/

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = nums.length + 1;

        int min = 0;
        while (l < r) {
            int mid = (l+r) >> 1;
            if (check(mid, nums, target)) {
                r = mid;
                min = mid;
            } else {
                l = mid+1;
            }
        }
        return min;
    }

    private boolean check(int size, int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size) {
                sum -= nums[i-size];
            }
            sum += nums[i];
            if (sum >= target) return true;
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
