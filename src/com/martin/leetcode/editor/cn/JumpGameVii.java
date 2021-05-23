//给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时
//满足如下条件时，你可以从下标 i 移动到下标 j 处： 
//
// 
// i + minJump <= j <= min(i + maxJump, s.length - 1) 且 
// s[j] == '0'. 
// 
//
// 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "011010", minJump = 2, maxJump = 3
//输出：true
//解释：
//第一步，从下标 0 移动到下标 3 。
//第二步，从下标 3 移动到下标 5 。
// 
//
// 示例 2： 
//
// 
//输入：s = "01101110", minJump = 2, maxJump = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 105 
// s[i] 要么是 '0' ，要么是 '1' 
// s[0] == '0' 
// 1 <= minJump <= maxJump < s.length 
// 
// Related Topics 贪心算法 广度优先搜索 Line Sweep 
// 👍 11 👎 0


package com.martin.leetcode.editor.cn;


public class JumpGameVii{
    public static void main(String[] args) {
       Solution solution = new JumpGameVii().new Solution();
        System.out.println(solution.canReach("01111111011110", 1, 9));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        char[] cc = s.toCharArray();
        boolean[] dp = new boolean[len];

        dp[0] = true;
        for (int i = 0; i < len; i++) {
            if (cc[i] == '1') continue;

            if (dp[i]) {
                for (int j = i + minJump; j <= i + maxJump && j < len && !dp[j]; j++) {
                    if (cc[j] == '0') dp[j] = true;
                }
            }
        }

        return dp[len-1];
    }

/*    public boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        char[] cc = s.toCharArray();
        int[] dp = new int[len+1];
        int[] pre = new int[len+1];

        dp[1] = 1;
        pre[1] = 1;

        for (int i = 2; i <= len; i++) {
            if (cc[i-1] == '0' && i - minJump >= 1) {
                int l = Math.max(1, i - maxJump), r = i - minJump;
                if (pre[r] - pre[l - 1] > 0 ) dp[i] = 1;
            }
            pre[i] = pre[i-1] + dp[i];
        }

        return dp[len] > 0;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}
