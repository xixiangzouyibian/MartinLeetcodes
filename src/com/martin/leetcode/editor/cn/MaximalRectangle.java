//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 示例: 
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 628 👎 0

  
package com.martin.leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle{

    public static void main(String[] args) {
        char[] test = new char[] {'1', '0', '1', '1'};
        int s = test.length - 1;
        while (s >= 0 && test[s] == '1') s--;
        System.out.println(s);
        Solution solution = new MaximalRectangle().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] width = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                    width[row][col] = 0;
                    continue;
                }
                int minWidth = width[row][col];
                for (int up_row = row; up_row >= 0 && width[row][col] > 0; up_row--) {
                    int height = row - up_row + 1;
                    minWidth = Math.min(minWidth, width[up_row][col]);
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }*/

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

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