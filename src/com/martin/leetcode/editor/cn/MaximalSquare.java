//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划 
// 👍 578 👎 0

  
package com.martin.leetcode.editor.cn;


public class MaximalSquare{

    public static void main(String[] args) {
        System.out.println(Math.pow((int)Math.sqrt(1) + 1, 2) == 4);
        Solution solution = new MaximalSquare().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int maximalSquare(char[][] matrix) {
        // base condition
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        int[][] dp = new int[height + 1][width + 1];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (matrix[row][col] == '1') {
                    dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
                    maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }*/

        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

            int height = matrix.length, width = matrix[0].length;
            int maxSide = 0;

            int[][] dp = new int[height][width];
            for (int i = height-1; i >= 0; i--) {
                for (int j = width-1; j >= 0; j--) {
                    if (j+1 == width || i+1 == height) {
                        dp[i][j] = matrix[i][j] - '0';
                    } else if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i+1][j+1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
            return maxSide * maxSide;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}