//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 764 👎 0


package com.martin.leetcode.editor.cn;


public class SudokuSolver{
    public static void main(String[] args) {
       Solution solution = new SudokuSolver().new Solution();
        System.out.println( 5 / 3 * 3);
        System.out.println('0');
        System.out.println((char)(5 + '0'));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        boolean[][] visitedRow = new boolean[9][10];
        boolean[][] visitedCol = new boolean[9][10];
        boolean[][][] visitedBlock = new boolean[3][3][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j]-'0';
                visitedRow[i][num] = true;
                visitedCol[j][num] = true;
                visitedBlock[i/3][j/3][num] = true;
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int x, int y) {
        if (y == 9) {
            y = 0;
            x++;
            if (x == 9) return true;
        }

        if (board[x][y] != '.') {
            return dfs(board, x, y + 1);
        } else {
            for (int num = 1; num <= 9; num++) {
                if (visitedBlock[x/3][y/3][num] || visitedRow[x][num] || visitedCol[y][num]) continue;

                board[x][y] = (char)(num + '0');
                visitedBlock[x/3][y/3][num] = true;
                visitedRow[x][num] = true;
                visitedCol[y][num] = true;

                if (dfs(board, x, y+1)) return true;

                board[x][y] = '.';
                visitedBlock[x/3][y/3][num] = false;
                visitedRow[x][num] = false;
                visitedCol[y][num] = false;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
