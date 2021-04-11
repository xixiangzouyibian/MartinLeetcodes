//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 堆 数学 动态规划 
// 👍 539 👎 0


package com.martin.leetcode.editor.cn;


public class UglyNumberIi{
    public static void main(String[] args) {
       Solution solution = new UglyNumberIi().new Solution();
        System.out.println(solution.nthUglyNumber(1352));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        List<Integer> candidates = Arrays.asList(2,3,5);
        Set<Long> set = new HashSet<>();

        queue.offer(1L);
        for (int i = 1; i <= n; i++) {
            long x = queue.poll();
            if (i == n) return (int) x;

            for (int c : candidates) {
                long cc = c * x;
                if (!set.contains(cc)) {
                    set.add(cc);
                    queue.offer(cc);
                }
            }
        }
        return 0;
    }*/

    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2, p1 = 1, p2 = 1, p3 = 1; i <= n; i++) {
            int n1 = dp[p1] * 2;
            int n2 = dp[p2] * 3;
            int n3 = dp[p3] * 5;
            int min = Math.min(n1, Math.min(n2, n3));
            dp[i] = min;
            if (n1 == min) p1++;
            if (n2 == min) p2++;
            if (n3 == min) p3++;
        }

        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
