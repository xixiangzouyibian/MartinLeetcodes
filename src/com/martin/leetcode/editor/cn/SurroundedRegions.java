//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 473 👎 0


package com.martin.leetcode.editor.cn;


import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions{
    public static void main(String[] args) {
       Solution solution = new SurroundedRegions().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public void solve(char[][] board) {
        int row = board.length;
        if (row <= 1) return;
        int col = board[0].length;

        int dummy = row * col;
        int[][] directions = new int[][] {{1,0},{0,-1},{-1,0},{0,1}};
        UnionFind unionFind = new UnionFind(dummy+1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        unionFind.union(i * col + j, dummy);
                    } else {
                        for (int[] d : directions) {
                            int x = i+d[0];
                            int y = j+d[1];
                            if (board[x][y] == 'O') {
                                unionFind.union(i*col+j, x*col+y);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 1; i < row-1; i++) {
            for (int j = 1; j < col-1; j++) {
                if (board[i][j] == 'O' && unionFind.find(i*col+j) != unionFind.find(dummy)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    class UnionFind {
        int[] p;
        public UnionFind(int len) {
            p = new int[len];
            for (int i = 0; i < len; i++) {
                p[i] = i;
            }
        }
        public int find(int id) {
            if (id != p[id]) {
                p[id] = find(p[id]);
            }
            return p[id];
        }
        public boolean union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                p[xRoot] = yRoot;
                return true;
            }
            return false;
        }
    }*/

    int[][] directions = new int[][] {{1,0},{0,-1},{-1,0},{0,1}};

/*    public void solve(char[][] board) {
        int row = board.length;
        if (row <= 1) return;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean isEdge = i == 0 || i == row-1 || j == 0 || j == col-1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(i, j, row, col, board);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, int row, int col, char[][] board) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];
            dfs(x, y, row, col, board);
        }
    }*/

    public void solve(char[][] board) {
        int row = board.length;
        if (row <= 1) return;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean isEdge = i == 0 || i == row-1 || j == 0 || j == col-1;
                if (isEdge && board[i][j] == 'O') {
                    bfs(i, j, row, col, board);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(int i, int j, int row, int col, char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (x >= 0 && x < row && y >= 0 && y < col && board[x][y] != '#' && board[x][y] == 'O') {
                board[x][y] = '#';
                for (int[] d : directions) {
                    queue.offer(new int[]{x + d[0], y + d[1]});
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
