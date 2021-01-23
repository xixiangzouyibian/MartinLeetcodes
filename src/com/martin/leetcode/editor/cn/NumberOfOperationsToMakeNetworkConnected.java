//用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [
//a, b] 连接了计算机 a 和 b。 
//
// 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。 
//
// 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连
//通所需的最少操作次数。如果不可能，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
//输出：1
//解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
//输出：2
// 
//
// 示例 3： 
//
// 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
//输出：-1
//解释：线缆数量不足。
// 
//
// 示例 4： 
//
// 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// 1 <= connections.length <= min(n*(n-1)/2, 10^5) 
// connections[i].length == 2 
// 0 <= connections[i][0], connections[i][1] < n 
// connections[i][0] != connections[i][1] 
// 没有重复的连接。 
// 两台计算机不会通过多条线缆连接。 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 106 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected{
    public static void main(String[] args) {
       Solution solution = new NumberOfOperationsToMakeNetworkConnected().new Solution();
        System.out.println(solution.makeConnected(4, new int[][] {{0,1},{0,2},{1,2}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if (n-len >= 2) return -1;

        UnionFind unionFind = new UnionFind(n);
        int extraConnect = 0;
        for (int i = 0; i < len; i++) {
            int x = connections[i][0];
            int y = connections[i][1];
            if (!unionFind.union(x, y)) {
                extraConnect++;
            }
        }
        return Math.min(unionFind.assembleNum-1, extraConnect);
    }

    class UnionFind {
        int[] p;
        int assembleNum = 0;

        public UnionFind(int len) {
            p = new int[len];
            for (int i = 0; i < len; i++) {
                p[i] = i;
                assembleNum++;
            }
        }

        public int find (int id) {
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
                assembleNum--;
                return true;
            }
            return false;
        }
    }*/

    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if (n-len >= 2) return -1;

        List<Integer>[] graph = new List[n];
        for (int k = 0; k < n; k++) {
            graph[k] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }

        boolean[] visited = new boolean[n];
        int assembleNum = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, i, graph);
                assembleNum++;
            }
        }

        return assembleNum-1;
    }

    public void dfs(boolean[] visited, int cur, List<Integer>[] graph) {
        if (!visited[cur]) {
            visited[cur] = true;
            for (int next : graph[cur]) {
                dfs(visited, next, graph);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
