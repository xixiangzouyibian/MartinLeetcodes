//English description is not available for the problem. Please switch to 
//Chinese. Related Topics 设计 队列 单调队列 👍 309 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DuiLieDeZuiDaZhiLcof{

    //leetcode submit region begin(Prohibit modification and deletion)
class MaxQueue {

    Deque<Integer> queue;
    Deque<Integer> max;

    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }
    
    public int max_value() {
        return max.isEmpty() ? -1 : max.peekFirst();
    }
    
    public void push_back(int value) {
        queue.offerLast(value);
        while (!max.isEmpty() && max.peekLast() <= value) {
            max.pollLast();
        }
        max.offerLast(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int value = queue.pollFirst();
        if (value == max.peekFirst()) {
            max.pollFirst();
        }
        return value;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}