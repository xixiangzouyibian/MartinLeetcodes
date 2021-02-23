//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 756 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens{
    public static void main(String[] args) {
       Solution solution = new NQueens().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] map = new char[n][n];
        for (char[] row : map) {
            Arrays.fill(row, '.');
        }
        List<List<String>> res = new ArrayList<>();
        dfs(map, 0, n, res);
        return res;
    }

    private void dfs(char[][] map, int level, int n, List<List<String>> res) {
        if (level == n) {
            List<String> solution = new ArrayList<>();
            for (char[] row : map) {
                solution.add(String.valueOf(row));
            }
            res.add(solution);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!check(map, level, i, n)) {
                continue;
            }
            map[level][i] = 'Q';
            dfs(map, level+1, n, res);
            map[level][i] = '.';
        }
    }

    private boolean check(char[][] map, int x, int y, int n) {
        int pie = x + y;
        int na = x - y;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (y == j && map[i][j] == 'Q') return false;
                if (i+j == pie && map[i][j] == 'Q') return false;
                if (i-j == na && map[i][j] == 'Q') return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
