//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 857 👎 0


package com.martin.leetcode.editor.cn;


public class KthLargestElementInAnArray{
    public static void main(String[] args) {
       Solution solution = new KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[] {5,2,4,1,3,6,0}, 4));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while (true) {
            int position = partition(nums, left, right);
            if (position < target) {
                left = position + 1;
            } else if (position > target) {
                right = position - 1;
            } else {
                return nums[position];
            }
        }
    }

/*    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;

        int position = partition(nums, start, end);
        quickSort(nums, start, position - 1);
        quickSort(nums, position + 1, end);
    }*/

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left+1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
