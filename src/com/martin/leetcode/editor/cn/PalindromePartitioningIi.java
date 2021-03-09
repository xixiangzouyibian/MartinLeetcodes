//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 动态规划 
// 👍 390 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;

public class PalindromePartitioningIi{
    public static void main(String[] args) {
       Solution solution = new PalindromePartitioningIi().new Solution();
        System.out.println(solution.minCut("aab"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCut(String s) {
        int len = s.length();
        if (len == 1) return 0;
        char[] chars = s.toCharArray();

        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (chars[i] == chars[j]) {
                    if (i+1 > j-1 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        int[] f = new int[len+1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (dp[i][j]) {
                    f[j+1] = Math.min(f[j+1], f[i]+1);
                }
            }
        }
        return f[len]-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
