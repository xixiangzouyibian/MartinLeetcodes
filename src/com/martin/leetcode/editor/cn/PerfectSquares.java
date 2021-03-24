//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 104 
// 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 807 👎 0


package com.martin.leetcode.editor.cn;


public class PerfectSquares{
    public static void main(String[] args) {
       Solution solution = new PerfectSquares().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int numSquares(int n) {
        return dfs(n, new int[10001]);
    }

    private int dfs(int target, int[] mem) {
        if (target == 0 || mem[target] != 0) return mem[target];

        int res = Integer.MAX_VALUE;
        for (int i = 1; target - i * i >= 0; i++) {
            mem[target-i*i] = dfs(target-i*i, mem);
            res = Math.min(res, mem[target-i*i]+1);
        }
        return res;
    }*/

/*    public int numSquares(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        boolean[] visit = new boolean[10001];
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int i = 1; i * i + cur <= n; i++) {
                    int next = i * i + cur;
                    if (next == n) return count;
                    if (!visit[next]) {
                        queue.offer(next);
                        visit[next] = true;
                    }
                }
            }
        }
        return count;
    }*/

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int j = 1; j <= n; j++) {
            dp[j] = j;
            for (int i = 1; j - i * i >= 0; i++) {
                dp[j] = Math.min(dp[j], dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
