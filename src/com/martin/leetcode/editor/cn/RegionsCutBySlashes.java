//在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。 
//
// （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。 
//
// 返回区域的数目。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：
//[
//  " /",
//  "/ "
//]
//输出：2
//解释：2x2 网格如下：
// 
//
// 示例 2： 
//
// 输入：
//[
//  " /",
//  "  "
//]
//输出：1
//解释：2x2 网格如下：
// 
//
// 示例 3： 
//
// 输入：
//[
//  "\\/",
//  "/\\"
//]
//输出：4
//解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
//2x2 网格如下：
// 
//
// 示例 4： 
//
// 输入：
//[
//  "/\\",
//  "\\/"
//]
//输出：5
//解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
//2x2 网格如下：
// 
//
// 示例 5： 
//
// 输入：
//[
//  "//",
//  "/ "
//]
//输出：3
//解释：2x2 网格如下：
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 30 
// grid[i][j] 是 '/'、'\'、或 ' '。 
// 
// Related Topics 深度优先搜索 并查集 图 
// 👍 222 👎 0


package com.martin.leetcode.editor.cn;


public class RegionsCutBySlashes{
    public static void main(String[] args) {
       Solution solution = new RegionsCutBySlashes().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        UnionFind unionFind = new UnionFind(4 * N * N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int index = 4 * (i * N + j);
                if (grid[i].charAt(j) == '/') {
                    unionFind.union(index, index+3);
                    unionFind.union(index+1, index+2);
                } else if (grid[i].charAt(j) == '\\') {
                    unionFind.union(index, index+1);
                    unionFind.union(index+2, index+3);
                } else {
                    unionFind.union(index, index+1);
                    unionFind.union(index+1, index+2);
                    unionFind.union(index+2, index+3);
                }

                if (i+1 < N) {
                    unionFind.union(index+2, 4 * ((i + 1) * N + j));
                }
                if (j+1 < N) {
                    unionFind.union(index+1, 4 * (i * N + j + 1) + 3);
                }
            }
        }
        return unionFind.count;
    }

    class UnionFind {
        int[] p;
        int count = -1;

        public UnionFind(int len) {
            p = new int[len];
            count = len;
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

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                p[xRoot] = yRoot;
                count--;
            }
        }
    }*/

    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        int[][] regions = new int[len*3][len*3];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i].charAt(j) == '\\') {
                    regions[i*3][j*3] = 1;
                    regions[i*3+1][j*3+1] = 1;
                    regions[i*3+2][j*3+2] = 1;
                }
                if (grid[i].charAt(j) == '/') {
                    regions[i*3][j*3+2] = 1;
                    regions[i*3+1][j*3+1] = 1;
                    regions[i*3+2][j*3] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < len*3; i++) {
            for (int j = 0; j < len*3; j++) {
                if (regions[i][j] == 0) {
                    dfs(i, j, len, regions);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int x, int y, int len, int[][] regions) {
        if (x >= 0 && x < len*3 && y >=0 && y < len*3 && regions[x][y] == 0) {
            regions[x][y] = 1;
            dfs(x+1, y, len, regions);
            dfs(x-1, y, len, regions);
            dfs(x, y+1, len, regions);
            dfs(x, y-1, len, regions);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
