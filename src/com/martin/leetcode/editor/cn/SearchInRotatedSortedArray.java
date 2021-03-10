//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1216 👎 0


package com.martin.leetcode.editor.cn;


public class SearchInRotatedSortedArray{
    public static void main(String[] args) {
       Solution solution = new SearchInRotatedSortedArray().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int search(int[] nums, int target) {
        int len = nums.length;
        if (nums[0] == target) {
            return 0;
        } else if (nums[0] < target) {
            for (int i = 0; i < len; i++) {
                if (nums[i] == target) return i;
                if (i > 0 && i+1 < len && nums[i-1] > nums[i] && nums[i] < nums[i+1])
                    break;
            }
        } else {
            for (int i = len-1; i >= 0; i--) {
                if (nums[i] == target) return i;
                if (i > 0 && i+1 < len && nums[i-1] > nums[i] && nums[i] < nums[i+1])
                    break;
            }
        }
        return -1;
    }*/

/*    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l < r) { // find partition
            int mid = l + r +1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid-1;
            }
        }

        if (nums[0] <= target) {
            l = 0;
        } else {
            l = r + 1;
            r = nums.length-1;
        }
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (nums[r] == target) return r;
        return -1;
    }*/

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[l]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid -1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
