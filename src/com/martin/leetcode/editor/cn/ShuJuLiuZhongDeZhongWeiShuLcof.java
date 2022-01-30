//English description is not available for the problem. Please switch to 
//Chinese. Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 240 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShuJuLiuZhongDeZhongWeiShuLcof{

    //leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

    private PriorityQueue<Integer> queueA;
    private PriorityQueue<Integer> queueB;

    /** initialize your data structure here. */
    public MedianFinder() {
        queueA = new PriorityQueue<>();
        queueB = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }
    
    public void addNum(int num) {
        if (!queueA.isEmpty() && num <= queueA.peek()) {
            queueB.offer(num);
            if (queueB.size() > queueA.size()) {
                queueA.offer(queueB.poll());
            }
        } else {
            queueA.offer(num);
            if (queueA.size() - 1 > queueB.size()) {
                queueB.offer(queueA.poll());
            }
        }
    }
    
    public double findMedian() {
        int size = queueA.size() + queueB.size();
        if ((size & 1) == 1) {
            return (double) queueA.peek();
        } else {
            return (double) (queueA.peek() + queueB.peek()) / 2;
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