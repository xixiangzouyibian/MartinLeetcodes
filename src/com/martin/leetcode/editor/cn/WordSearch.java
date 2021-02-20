//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 787 👎 0


package com.martin.leetcode.editor.cn;


public class WordSearch{
    public static void main(String[] args) {
       Solution solution = new WordSearch().new Solution();
        System.out.println(solution.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] directions = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, row, col, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

        private boolean dfs(char[][] board, int x, int y, int row, int col, int level, String word, boolean[][] visited) {
            if (level == word.length()-1) {
                return board[x][y] == word.charAt(level);
            }
            if (word.charAt(level) == board[x][y]) {
                visited[x][y] = true;
                for (int[] d : directions) {
                    int X = x + d[0];
                    int Y = y + d[1];
                    if (X >= 0 && X < row && Y >= 0 && Y < col && !visited[X][Y]) {
                         if (dfs(board, X, Y, row, col, level+1, word, visited)) {
                             return true;
                         }
                    }
                }
                visited[x][y] = false;
            }
            return false;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
