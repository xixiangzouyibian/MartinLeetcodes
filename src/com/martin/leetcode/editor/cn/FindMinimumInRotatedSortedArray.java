//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。 
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 380 👎 0


package com.martin.leetcode.editor.cn;


public class FindMinimumInRotatedSortedArray{
    public static void main(String[] args) {
       Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        if (nums[l] <= nums[r]) return nums[0];

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
