//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 372 👎 0


package com.martin.leetcode.editor.cn;


public class SpiralMatrixIi{
    public static void main(String[] args) {
       Solution solution = new SpiralMatrixIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        dfs(0, 0, n-1, n-1, 1, n * n, res);
        return res;
    }

    private void dfs(int x1, int y1, int x2, int y2, int num, int n, int[][] res) {
        if (x1 > x2 || y1 > y2) return;
        if (x1 == x2) {
            for (int j = y1; j <= y2 && num <= n; j++) {
                res[x1][j] = num;
            }
        } else if (y1 == y2) {
            for (int i = x1; i <= x2 && num <= n; i++) {
                res[i][y1] = num;
            }
        } else {
            for (int j = y1; j < y2 && num <= n; j++) {
                res[x1][j] = num;
                num++;
            }
            for (int i = x1; i < x2 && num <= n; i++) {
                res[i][y2] = num;
                num++;
            }
            for (int j = y2; j > y1 && num <= n; j--) {
                res[x2][j] = num;
                num++;
            }
            for (int i = x2; i > x1 && num <= n; i--) {
                res[i][y1] = num;
                num++;
            }
        }

        dfs(x1+1, y1+1, x2-1, y2-1, num, n, res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
