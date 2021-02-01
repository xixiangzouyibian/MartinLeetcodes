//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 792 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;

public class MergeIntervals{
    public static void main(String[] args) {
       Solution solution = new MergeIntervals().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int index = 0;
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            if (i == 0 || intervals[i][0] > res[index-1][1]) {
                res[index++] = intervals[i];
            } else {
                res[index-1][1] = Math.max(res[index-1][1], intervals[i][1]);
            }
        }
        return Arrays.copyOf(res, index);
    }*/

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
