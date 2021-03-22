//给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，为避免
//会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[0,30],[5,10],[15,20]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[7,10],[2,4]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// 0 <= starti < endi <= 106 
// 
// Related Topics 堆 贪心算法 排序 
// 👍 242 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsIi{
    public static void main(String[] args) {
       Solution solution = new MeetingRoomsIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        queue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (!queue.isEmpty() && intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size();
    }*/

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        queue.offer(intervals[0][1]);
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (!queue.isEmpty() && intervals[i][0] < queue.peek()) {
                res++;
            } else {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
