//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 846 👎 0

  
package com.martin.leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands{

    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    findBfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    private void findDfs(char[][] grid, int i, int j, int m, int n) {
        if (i >= m || j >= n || i < 0 || j < 0 || grid[i][j] == '0') return;

        grid[i][j] = '0';
        findDfs(grid, i+1, j, m, n);
        findDfs(grid, i, j+1, m, n);
        findDfs(grid, i-1, j, m, n);
        findDfs(grid, i, j-1, m, n);
    }

    private void findBfs(char[][] grid, int i, int j, int m, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        if (grid[i][j] == '1') {
            queue.offer(new int[] {i, j});
        }
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int r = position[0], c = position[1];

            if (r >= m || c >= n || r < 0 || c < 0 || grid[r][c] == '0') continue;

            grid[r][c] = '0';
            queue.offer(new int[] {r+1, c});
            queue.offer(new int[] {r, c+1});
            queue.offer(new int[] {r-1, c});
            queue.offer(new int[] {r, c-1});

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}