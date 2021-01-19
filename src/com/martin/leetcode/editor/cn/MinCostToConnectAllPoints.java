//给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。 
//
// 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 
//val 的绝对值。 
//
// 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//输出：20
//解释：
//
//我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
//注意到任意两个点之间只有唯一一条路径互相到达。
// 
//
// 示例 2： 
//
// 
//输入：points = [[3,12],[-2,5],[-4,1]]
//输出：18
// 
//
// 示例 3： 
//
// 
//输入：points = [[0,0],[1,1],[1,0],[-1,1]]
//输出：4
// 
//
// 示例 4： 
//
// 
//输入：points = [[-1000000,-1000000],[1000000,1000000]]
//输出：4000000
// 
//
// 示例 5： 
//
// 
//输入：points = [[0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 1000 
// -106 <= xi, yi <= 106 
// 所有点 (xi, yi) 两两不同。 
// 
// Related Topics 并查集 
// 👍 112 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinCostToConnectAllPoints{
    public static void main(String[] args) {
       Solution solution = new MinCostToConnectAllPoints().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        UnionFind unionFind = new UnionFind(len);
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                edges.add(new Edge(i, j, Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])));
            }
        }
        edges.sort(Comparator.comparingInt(e -> e.value));
        int res = 0;
        for (Edge edge : edges) {
            int a = unionFind.find(edge.a);
            int b = unionFind.find(edge.b);
            if (a != b) {
                unionFind.simpleUnion(a, b);
                res += edge.value;
            }
        }
        return res;
    }

    class Edge {
        int a;
        int b;
        int value;
        public Edge(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }
    }

    class UnionFind {
        private int[] p;

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

        public void simpleUnion(int x, int y) {
            p[x] = y;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                p[xRoot] = yRoot;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
