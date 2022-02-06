//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 设计 队列 数据流 👍 11 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.xml.bind.annotation.XmlInlineBinaryData;

public class H8086Q{

    //leetcode submit region begin(Prohibit modification and deletion)
/*class RecentCounter {

    private List<Integer> timeLine;

    public RecentCounter() {
        timeLine = new ArrayList<>();
    }
    
*//*    public int ping(int t) {
        timeLine.add(t);
        int start = Math.max(0, t - 3000);
        int index = Collections.binarySearch(timeLine, start);
        if (index >= 0) {
            return timeLine.size() - index;
        } else {
            return timeLine.size() + index + 1;
        }
    }*//*

    public int ping(int t) {
        timeLine.add(t);
        int l = 0;
        int r = timeLine.size();
        while (l < r) {
            int mid = l + r >> 1;
            if (timeLine.get(mid) < t - 3000) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return timeLine.size() - l;
    }
}*/

class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
//leetcode submit region end(Prohibit modification and deletion)

}