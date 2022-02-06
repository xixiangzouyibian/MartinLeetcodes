//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 设计 线段树 有序集合 👍 12 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.Map;
import java.util.TreeMap;

public class Fi9suh{

    //leetcode submit region begin(Prohibit modification and deletion)
class MyCalendar {

    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floor = map.floorEntry(start);
        if (floor != null && floor.getValue() > start) return false;

        Map.Entry<Integer, Integer> ceil = map.ceilingEntry(start);
        if (ceil != null && ceil.getKey() < end) return false;

        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)

}