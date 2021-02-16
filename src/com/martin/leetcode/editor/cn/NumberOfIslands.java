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


public class NumberOfIslands{

    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row < 1) return 0;
        int col = grid[0].length;

        UnionFind unionFind = new UnionFind(row * col);
        int[][] directions = new int[][] {{1,0},{0,1}};
        int space = 0;
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    space++;
                } else {
                    for (int[] d : directions) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            unionFind.union(i*col+j, x*col+y);
                        }
                    }
                }
            }
        }
        return unionFind.count-space;
    }

    class UnionFind {
        int[] p;
        int count;
        public UnionFind(int len) {
            p = new int[len];
            count = len;
            for (int i = 0; i < len; i++) {
                p[i] = i;
            }
        }
        public int find(int id) {
            if (p[id] != id) {
                p[id] = find(p[id]);
            }
            return p[id];
        }
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                p[xRoot] = yRoot;
                count--;
            }
        }
    }*/

    int[][] directions = new int[][] {{1,0},{0,-1},{-1,0},{0,1}};

    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row < 1) return 0;
        int col = grid[0].length;

        boolean[][] isVisited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    dfs(i, j, row, col, grid, isVisited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int row, int col, char[][] grid, boolean[][] isVisited) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0' || isVisited[i][j]) {
            return;
        }
        isVisited[i][j] = true;
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            dfs(x, y, row, col, grid, isVisited);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}