//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 设计 数组 矩阵 前缀和 👍 17 👎 0

  
package com.martin.leetcode.editor.cn;

public class O4NDxx{

    //leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {

    private int[][] preSum;
    public NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                preSum[i + 1][j + 1] = matrix[i][j] + preSum[i][j+1] + preSum[i+1][j] - preSum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1] - preSum[row2+1][col1] - preSum[row1][col2+1] + preSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}