//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 300 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 1035 👎 0


package com.martin.leetcode.editor.cn;


public class FirstMissingPositive{
    public static void main(String[] args) {
       Solution solution = new FirstMissingPositive().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int res = 1;
        while (set.contains(res)) res++;
        return res;
    }*/

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] >=1 && nums[i] <= len && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1) return i+1;
        }
        return len+1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
