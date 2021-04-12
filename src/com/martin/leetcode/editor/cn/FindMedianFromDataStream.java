//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 堆 设计 
// 👍 401 👎 0


package com.martin.leetcode.editor.cn;


import java.util.PriorityQueue;

public class FindMedianFromDataStream{

    //leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    PriorityQueue<Integer> largeHeap;
    PriorityQueue<Integer> smallHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        largeHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        smallHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }
    
    public void addNum(int num) {
        if (!largeHeap.isEmpty() && num <= largeHeap.peek()) {
            largeHeap.offer(num);
            if (largeHeap.size() > smallHeap.size() + 1) {
                smallHeap.offer(largeHeap.poll());
            }
        } else {
            smallHeap.offer(num);
            if (smallHeap.size() > largeHeap.size()) {
                largeHeap.offer(smallHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        int size = largeHeap.size() + smallHeap.size();
        if ((size & 1) == 1) {
            return largeHeap.peek();
        } else {
            return (largeHeap.peek() + smallHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
