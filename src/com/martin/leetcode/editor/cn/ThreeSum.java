//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2831 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
       Solution solution = new ThreeSum().new Solution();
       System.out.println(Arrays.asList(-1, 1).equals(Arrays.asList(-1, 1)));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            twoSum(nums, i+1, len-1, target, ans);
        }
        return new ArrayList<>(ans);
    }

    public void twoSum(int[] nums, int start, int end, int target, List<List<Integer>> ans) {
        while (start < end) {
            int twoSum = nums[start]+nums[end];
            if (twoSum == target) {
                ans.add(Arrays.asList(-target, nums[start], nums[end]));
                while (start < end && nums[start] == nums[start+1]) start++;
                while (start < end && nums[end] == nums[end-1]) end--;
                start++;
                end--;
            } else if (twoSum < target) {
                start++;
            } else {
                end--;
            }
        }
    }

/*    public void twoSum(int[] nums, int start, int end, int target, Set<List<Integer>> ans) {
        Map<Integer, Integer> map = new HashMap<>();
        while (start < end) {
            int num = nums[start];
            if (map.containsKey(num)) {
                ans.add(Arrays.asList(-target, map.get(num), num));
            } else {
                map.put(target - num, num);
            }
            start++;
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}
