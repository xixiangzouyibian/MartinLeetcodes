//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 461 👎 0


package com.martin.leetcode.editor.cn;


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces{
    public static void main(String[] args) {
       Solution solution = new NumberOfProvinces().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] p = new int[len];
        for (int i = 0; i < len; i++) {
            p[i] = i;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, p);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (p[i] == i) {
                count++;
            }
        }
        return count;
    }

    private void union(int i, int j, int[] p) {
        int rootI = find(i, p);
        int rootJ = find(j, p);
        p[rootI] = rootJ;
    }

    private int find(int j, int[] p) {
        if (j != p[j]) {
            p[j] = find(p[j], p);
        }
        return p[j];
    }*/

/*    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] isVisited = new boolean[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (!isVisited[i]) {
                count++;
                dfs(i, isConnected, isVisited);
            }
        }
        return count;
    }

    private void dfs(int i, int[][] isConnected, boolean[] isVisited) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                isVisited[j] = true;
                dfs(j, isConnected, isVisited);
            }
        }
    }*/

    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[len];

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (isVisited[i]) {
                continue;
            }
            count++;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int j = queue.poll();
                isVisited[j] = true;
                for (int k = 0; k < len; k++) {
                    if (isConnected[j][k] == 1 && !isVisited[k]) {
                        queue.offer(k);
                    }
                }
            }
        }

        return count;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
