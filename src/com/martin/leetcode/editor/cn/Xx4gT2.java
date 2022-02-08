//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 22 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.PriorityQueue;

public class Xx4gT2{
    public static void main(String[] args) {
       Solution solution = new Xx4gT2().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length, k);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int from, int to, int k) {
        if (from >= to) {
            return;
        }
        int position = partition(nums, from, to);
        if (nums.length - k == position) {
            return;
        }
        quickSort(nums, from, position, k);
        quickSort(nums, position+1, to, k);
    }

    private int partition(int[] nums, int from, int to) {
        int pivot = nums[from];
        int position = from;
        for (int i = from + 1; i < to; i++) {
            if (nums[i] <= pivot) {
                position++;
                swap(nums, position, i);
            }
        }
        swap(nums, from, position);
        return position;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }*/

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            if (queue.size() < k) {
                queue.offer(n);
            } else {
                if (n > queue.peek()) {
                    queue.poll();
                    queue.offer(n);
                }
            }
        }
        return queue.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}