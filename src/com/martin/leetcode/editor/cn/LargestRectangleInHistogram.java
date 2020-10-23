//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 970 👎 0

  
package com.martin.leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram{

    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>(heights.length);
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int top = stack.peek() == -1 ? -1 : heights[stack.peek()];
            if (heights[i] >= top) {
                stack.push(i);
                continue;
            }
            while (heights[i] < top) {
                max = Math.max(max, heights[stack.pop()] * (i-stack.peek()-1));
                top = stack.peek() == -1 ? -1 : heights[stack.peek()];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (stack.isEmpty()) break;
            max = Math.max(max, heights[index] * (heights.length-stack.peek()-1));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}