package com.martin.leetcode.editor.cn.template;

public class MergeSort {

    public static void sort(int[] nums) {
        _mergeSort(nums, 0, nums.length-1);
    }

    private static void _mergeSort(int[] nums, int from, int to) {
        if (from >= to) {
            return;
        }
        int mid = from + to >> 1;
        _mergeSort(nums, from, mid);
        _mergeSort(nums, mid+1, to);
        merge(nums, from, mid, to);
    }

    private static void merge(int[] nums, int from, int mid, int to) {
        int[] temp = new int[to - from + 1];
        int i = from, j = mid + 1, k = 0;
        while (i <= mid && j <= to) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= to) temp[k++] = nums[j++];
        System.arraycopy(temp, 0, nums, from, temp.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,5,6,4};
        MergeSort.sort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}