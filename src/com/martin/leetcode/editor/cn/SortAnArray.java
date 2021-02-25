//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 214 👎 0


package com.martin.leetcode.editor.cn;


public class SortAnArray{
    public static void main(String[] args) {
       Solution solution = new SortAnArray().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
//        mergeSort(nums, 0, nums.length-1);
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

        /**
         * Quick Sort
         * @param nums
         * @param l
         * @param r
         */
/*    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid-1);
        quickSort(nums, mid+1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int index = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        nums[r] = nums[index];
        nums[index] = pivot;
        return index;
    }*/

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l-1, j = r+1;
        int pivot = nums[l + r >> 1];
        while (i < j) {
            do { i++; } while (nums[i] < pivot);
            do { j--; } while (nums[j] > pivot);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort(nums, l, j); // carefully i >= j case, so need to just j
        quickSort(nums, j+1, r);
    }


        /**
         * Merge Sort
         * @param nums
         * @param l
         * @param r
         */
    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;

        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        int[] temp = new int[r-l+1];
        int k = 0, i = l, j = m+1;
        while (i <= m && j <= r) {
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= m) temp[k++] = nums[i++];
        while (j <= r) temp[k++] = nums[j++];

        for (int n = l; n <= r; n++) {
            nums[n] = temp[n-l];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
