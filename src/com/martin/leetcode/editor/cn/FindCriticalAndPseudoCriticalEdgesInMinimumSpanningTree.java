//给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，其中 edges[i] = [fromi, toi, we
//ighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权
//值和最小。 
//
// 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。伪关键边则是可能会出现在
//某些最小生成树中但不会出现在所有最小生成树中的边。 
//
// 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
//输出：[[0,1],[2,3,4,5]]
//解释：上图描述了给定图。
//下图是所有的最小生成树。
//
//注意到第 0 条边和第 1 条边出现在了所有最小生成树中，所以它们是关键边，我们将这两个下标作为输出的第一个列表。
//边 2，3，4 和 5 是所有 MST 的剩余边，所以它们是伪关键边。我们将它们作为输出的第二个列表。
// 
//
// 示例 2 ： 
//
// 
//
// 输入：n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
//输出：[[],[0,1,2,3]]
//解释：可以观察到 4 条边都有相同的权值，任选它们中的 3 条可以形成一棵 MST 。所以 4 条边都是伪关键边。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 1 <= edges.length <= min(200, n * (n - 1) / 2) 
// edges[i].length == 3 
// 0 <= fromi < toi < n 
// 1 <= weighti <= 1000 
// 所有 (fromi, toi) 数对都是互不相同的。 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 77 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree{
    public static void main(String[] args) {
       Solution solution = new FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            p.add(i);
        }

        List<Edge> edgeObj = new ArrayList<>();
        for (int i = 0; i< edges.length; i++) {
            edgeObj.add(new Edge(i, edges[i][0], edges[i][1], edges[i][2]));
        }

        int minTreeWeight = minTreeWeightCal(new ArrayList<>(p), edgeObj, 0);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        List<Edge> tempEdgeObj = new ArrayList<>(edgeObj);

        for (Edge edge : edgeObj) {
            tempEdgeObj.remove(edge);
            if (minTreeWeight != minTreeWeightCal(new ArrayList<>(p), tempEdgeObj, 0)) {
                res.get(0).add(edge.id);
            }
            tempEdgeObj.add(edge);
        }

        for (Edge edge : edgeObj) {
            if (res.get(0).contains(edge.id)) continue;
            List<Integer> tp = new ArrayList<>(p);
            tp.set(edge.a, edge.b);
            if (minTreeWeight == minTreeWeightCal(tp, tempEdgeObj, edge.weight)) {
                res.get(1).add(edge.id);
            }
        }

        return res;
    }

    private int minTreeWeightCal(List<Integer> p, List<Edge> edgeObj, int weight) {
        Collections.sort(edgeObj, (a, b) -> a.weight - b.weight);
        for (Edge edge : edgeObj) {
            int a = find(p, edge.a);
            int b = find(p, edge.b);
            if (a != b) {
                weight += edge.weight;
                p.set(a, b);
            }
        }
        return weight;
    }

    private int find(List<Integer> p, int x) {
        if (p.get(x) != x) {
            p.set(x, find(p, p.get(x)));
        }
        return p.get(x);
    }

    class Edge {
        public int id, a, b, weight;
        public Edge(int id, int a, int b, int weight) {
            this.id = id;
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }*/

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len = edges.length;

        int[][] graph = new int[len][3];
        for(int i = 0; i < len; i++){
            System.arraycopy(edges[i], 0, graph[i], 0, 3);
        }

        Arrays.sort(graph, (a , b) -> a[2] - b[2]);
        int originWeight = kruskalCal(graph, n, null, null);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for (int i = 0; i < len; i++) {
            if (originWeight != kruskalCal(graph, n, null, edges[i])) {
                res.get(0).add(i);
            } else {
                if (originWeight == kruskalCal(graph, n, edges[i], null)) {
                    res.get(1).add(i);
                }
            }
        }
        return res;
    }

    public int kruskalCal(int[][] edges, int n, int[] incl, int[] excl) { // This edges are sorted by weights
        UnionFind unionFind = new UnionFind(n);
        int weight = 0;
        if (incl != null) {
            unionFind.union(incl[0], incl[1]);
            weight += incl[2];
        }

        for (int[] edge : edges) {
            if (excl != null && excl[0] == edge[0] && excl[1] == edge[1]) continue;
            if (unionFind.union(edge[0], edge[1])) {
                weight += edge[2];
            }
        }
        return weight;
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

        public boolean union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                p[xRoot] = yRoot;
                return true;
            }
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
