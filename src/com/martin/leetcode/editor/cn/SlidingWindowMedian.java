//中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。 
//
// 例如： 
//
// 
// [2,3,4]，中位数是 3 
// [2,3]，中位数是 (2 + 3) / 2 = 2.5 
// 
//
// 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗
//口中元素的中位数，并输出由它们组成的数组。 
//
// 
//
// 示例： 
//
// 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。 
//
// 
//窗口位置                      中位数
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7      -1
// 1  3 [-1  -3  5] 3  6  7      -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
// 
//
// 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。 
//
// 
//
// 提示： 
//
// 
// 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。 
// 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。 
// 
// Related Topics Sliding Window 
// 👍 228 👎 0


package com.martin.leetcode.editor.cn;


import java.util.PriorityQueue;

public class SlidingWindowMedian{
    public static void main(String[] args) {
       Solution solution = new SlidingWindowMedian().new Solution();
        System.out.println(solution.medianSlidingWindow(new int[] {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((a,b)->Integer.compare(b,a)));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(((a,b)->Integer.compare(a,b)));
        double[] res = new double[len-k+1];

        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            maxHeap.add(minHeap.poll());
        }
        res[0] = getMid(maxHeap, minHeap, k);
        for (int i = k; i < len; i++) {
            if (nums[i] >= minHeap.peek()) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
            if (nums[i-k] >= minHeap.peek()) {
                minHeap.remove(nums[i-k]);
            } else {
                maxHeap.remove(nums[i-k]);
            }

            while (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            }
            while (minHeap.size() < maxHeap.size()) {
                minHeap.add(maxHeap.poll());
            }
            res[i-k+1] = getMid(maxHeap, minHeap, k);
        }
        return res;
    }

    public double getMid(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int k) {
        if ((k & 1) == 1) {
            return minHeap.peek();
        } else {
            return maxHeap.peek() * 0.5 + minHeap.peek() * 0.5;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
