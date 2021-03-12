//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 810 👎 0


package com.martin.leetcode.editor.cn;


public class SortColors{
    public static void main(String[] args) {
       Solution solution = new SortColors().new Solution();
       solution.sortColors(new int[]{1,2,0});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len == 1) return;

        int index0 = 0, index2 = len-1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                swap(nums, i, index0);
                index0++;
            } else if (nums[i] == 2) {
                swap(nums, i, index2);
                index2--;
                i--;
            }
            if (index0 >= index2 || i >= index2) break;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }*/

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int index = partition(nums, l, r);
        quickSort(nums, l, index-1);
        quickSort(nums, index+1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int target = nums[r];
        int count = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < target) {
                swap(nums, i, count++);
            }
        }
        swap(nums, count, r);
        return count;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
