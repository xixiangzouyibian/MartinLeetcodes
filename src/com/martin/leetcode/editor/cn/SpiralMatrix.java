//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 685 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix{
    public static void main(String[] args) {
       Solution solution = new SpiralMatrix().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();

        int x = 0, y = 0;
        while (x <= m && y <= n) {
            for (int i = y; i <= n; i++) {
                res.add(matrix[x][i]);
            }
            x++;
            if (x > m) break;
            for (int j = x; j <= m; j++) {
                res.add(matrix[j][n]);
            }
            n--;
            if (y > n) break;
            for (int i = n; i >= y; i--) {
                res.add(matrix[m][i]);
            }
            m--;
            if (x > m) break;
            for (int j = m; j >= x; j--) {
                res.add(matrix[j][y]);
            }
            y++;
        }

        return res;
    }*/

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        int[][] d = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for (int x = 0, y = 0, i = 0, start = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            matrix[x][y] = Integer.MIN_VALUE;

            int nx = x + d[start][0];
            int ny = y + d[start][1];
            if ( nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] == Integer.MIN_VALUE) {
                start = (start+1) % 4;
                nx = x + d[start][0];
                ny = y + d[start][1];
            }
            x = nx;
            y = ny;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
