//给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。 
//
// 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。 
//
// 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。 
//
// 
//
// 示例 1： 
//
// 输入：
//nums = [1, 7, 3, 6, 5, 6]
//输出：3
//解释：
//索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
//同时, 3 也是第一个符合要求的中心索引。
// 
//
// 示例 2： 
//
// 输入：
//nums = [1, 2, 3]
//输出：-1
//解释：
//数组中不存在满足此条件的中心索引。 
//
// 
//
// 说明： 
//
// 
// nums 的长度范围为 [0, 10000]。 
// 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。 
// 
// Related Topics 数组 
// 👍 264 👎 0


package com.martin.leetcode.editor.cn;


public class FindPivotIndex{
    public static void main(String[] args) {
       Solution solution = new FindPivotIndex().new Solution();
        System.out.println(solution.pivotIndex(new int[] {1,7,3,6,5,6}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len-1;

        int[] dpL = new int[len];
        int[] dpR = new int[len];

        dpL[0] = nums[0];
        dpR[len-1] = nums[len-1];
        for (int i = 1, j = len-2; i < len && j >= 0; i++, j--) {
            dpL[i] = dpL[i-1] + nums[i];
            dpR[j] = dpR[j+1] + nums[j];
        }
        for (int k = 0; k < len; k++) {
            if (dpL[k] == dpR[k]) return k;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
