//在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。 
//
// 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两
//个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。 
//
// 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？ 
//
// 
//
// 示例 1: 
//
// 
//输入: [[0,2],[1,3]]
//输出: 3
//解释:
//时间为0时，你位于坐标方格的位置为 (0, 0)。
//此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
//
//等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
// 
//
// 示例2: 
//
// 
//输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6
//]]
//输出: 16
//解释:
// 0  1  2  3  4
//24 23 22 21  5
//12 13 14 15 16
//11 17 18 19 20
//10  9  8  7  6
//
//最终的路线用加粗进行了标记。
//我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
// 
//
// 
//
// 提示: 
//
// 
// 2 <= N <= 50. 
// grid[i][j] 是 [0, ..., N*N - 1] 的排列。 
// 
// Related Topics 堆 深度优先搜索 并查集 二分查找 
// 👍 86 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater{
    public static void main(String[] args) {
       Solution solution = new SwimInRisingWater().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*        int[][] directions = new int[][] {{1,0},{0,-1},{-1,0},{0,1}};
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int low = 0;
        int high = N * N -1;
        while (low < high) {
            int mid = (low+high) >> 1;
            if (dfs(0,0,N,mid,grid,new boolean[N][N])) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    public boolean dfs(int r, int c, int N, int max, int[][] grid, boolean[][] visited) {
        if (grid[r][c] > max) return false;
        if (r == N-1 && c == N-1) return true;
        visited[r][c] = true;
        for (int[] d : directions) {
            int rNew = r + d[0];
            int cNew = c + d[1];
            if (rNew >= 0 && rNew < N && cNew >= 0 && cNew < N
                    && !visited[rNew][cNew]) {
                if (dfs(rNew, cNew, N, max, grid, visited)) return true;
            }
        }
        return false;
    }*/


/*    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int len = N * N;

        int[] index = new int[len];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                index[grid[i][j]] = N * i + j;
            }
        }

        UnionFind unionFind = new UnionFind(len);
        int[][] directions = new int[][] {{1,0},{0,-1},{-1,0},{0,1}};
        for (int i = 0; i < len; i++) {
            int x = index[i] / N;
            int y = index[i] % N;
            for (int[] d : directions) {
                int xNew = x + d[0];
                int yNew = y + d[1];
                if (xNew >=0 && xNew < N && yNew >= 0 && yNew < N && grid[xNew][yNew] <= i) {
                    unionFind.union(index[i], xNew * N + yNew);
                }

                if (unionFind.find(0) == unionFind.find(len-1)) return i;
            }
        }
        return -1;
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
            }
        }
    }*/

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(N, Comparator.comparingInt(o -> o[2]));
        boolean[][] visited = new boolean[N][N];
        int[][] directions = new int[][] {{1,0},{0,-1},{-1,0},{0,1}};

        minHeap.offer(new int[] {0,0,grid[0][0]});

        int ans = 0;
        while (!minHeap.isEmpty()) {
            int[] edge = minHeap.poll();
            int x = edge[0];
            int y = edge[1];
            int val = edge[2];
            visited[x][y] = true;
            ans = Math.max(ans, val);

            if (x == N-1 && y == N-1) return ans;

            for (int[] d : directions) {
                int xNew = x + d[0];
                int yNew = y + d[1];
                if (xNew >=0 && xNew < N && yNew >= 0 && yNew < N && !visited[xNew][yNew]) {
                    minHeap.offer(new int[] {xNew, yNew, grid[xNew][yNew]});
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
