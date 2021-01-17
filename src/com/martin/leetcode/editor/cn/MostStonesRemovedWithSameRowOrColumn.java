//n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。 
//
// 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。 
//
// 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//输出：5
//解释：一种移除 5 块石头的方法如下所示：
//1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
//2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
//3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
//4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
//5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
//石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。 
//
// 示例 2： 
//
// 
//输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
//输出：3
//解释：一种移除 3 块石头的方法如下所示：
//1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
//2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
//3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
//石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。 
//
// 示例 3： 
//
// 
//输入：stones = [[0,0]]
//输出：0
//解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 1000 
// 0 <= xi, yi <= 104 
// 不会有两块石头放在同一个坐标点上 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 186 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrColumn{
    public static void main(String[] args) {
       Solution solution = new MostStonesRemovedWithSameRowOrColumn().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(stones, i, n, visited);
            count++;
        }
        return n - count;
    }

    private void dfs(int[][] stones, int start, int n, boolean[] visited) {
        int x = stones[start][0];
        int y = stones[start][1];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (x == stones[i][0] || y == stones[i][1]) {
                visited[i] = true;
                dfs(stones, i, n, visited);
            }
        }
    }*/

    public int removeStones(int[][] stones) {
        int len = stones.length;
        UnionFind unionFind = new UnionFind();
        for (int i = 0; i < len; i++) {
            unionFind.union(stones[i][0] + 10001, stones[i][1]);
        }
        return len - unionFind.count;
    }

    class UnionFind {

        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            parent = new HashMap<>();
            count = 0;
        }

        public int find(int id) {
            if (!parent.containsKey(id)) {
                parent.put(id, id);
                count++;
            }

            if (id != parent.get(id)) {
                parent.put(id, find(parent.get(id)));
            }
            return parent.get(id);
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot != yRoot) {
                parent.put(xRoot, yRoot);
                count--;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
