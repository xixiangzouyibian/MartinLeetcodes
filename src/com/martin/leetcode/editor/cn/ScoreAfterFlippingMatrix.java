//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心算法 
// 👍 186 👎 0


package com.martin.leetcode.editor.cn;


public class ScoreAfterFlippingMatrix{
    public static void main(String[] args) {
       Solution solution = new ScoreAfterFlippingMatrix().new Solution();
        System.out.println(solution.matrixScore(new int[][] {{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        boolean rowUpdate = false;
        boolean colUpdate = false;
    public int matrixScore(int[][] A) {
        int rowLen = A.length;
        int colLen = A[0].length;
        while (true) {
            dfsRow(A, 0, rowLen, colLen);
            dfsCol(A, 0, rowLen, colLen);
            if (!rowUpdate && !colUpdate) break;
            rowUpdate = false;
            colUpdate = false;
        }

        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                res += A[i][j] * Math.pow(2, colLen-1-j);
            }
        }
        return res;
    }

    public void dfsRow(int[][]A, int row, int rowLen, int colLen) {
        if (row >= rowLen) return;
        if (A[row][0] == 0) {
            for (int i = 0; i < colLen; i++) {
                A[row][i] = 1 - A[row][i];
                rowUpdate = true;
            }
        }
        dfsRow(A, row+1, rowLen, colLen);
    }

    public void dfsCol(int[][]A, int col, int rowLen, int colLen) {
        if (col >= colLen) return;
        int count0 = 0;
        for (int j = 0; j < rowLen; j++) {
            if (A[j][col] == 0)
                count0++;
        }
        if (count0 > rowLen - count0) {
            for (int j = 0; j < rowLen; j++) {
                A[j][col] = 1 - A[j][col];
            }
            colUpdate = true;
        }
        dfsCol(A, col+1, rowLen, colLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
