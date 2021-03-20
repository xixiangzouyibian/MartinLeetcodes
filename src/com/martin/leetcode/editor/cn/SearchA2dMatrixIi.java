//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matix[i][j] <= 109 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -109 <= target <= 109 
// 
// Related Topics 二分查找 分治算法 
// 👍 570 👎 0


package com.martin.leetcode.editor.cn;


public class SearchA2dMatrixIi{
    public static void main(String[] args) {
       Solution solution = new SearchA2dMatrixIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0, j = col-1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }*/

    public boolean searchMatrix(int[][] matrix, int target) {
        int shorten = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorten; i++) {
            if (binarySearch(matrix, i, target, true) ||
                binarySearch(matrix, i, target, false)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int pos, int target, boolean isHorizon) {
        int start = pos, end = isHorizon ? matrix[0].length-1 : matrix.length-1;
        while (start <= end) { // it's important
            int mid = (start + end) >> 1;
            int cur = isHorizon ? matrix[pos][mid] : matrix[mid][pos];
            if (cur == target) return true;
            if (cur > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
