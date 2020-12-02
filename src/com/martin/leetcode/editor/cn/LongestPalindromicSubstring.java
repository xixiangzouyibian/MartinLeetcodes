//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2956 👎 0

  
package com.martin.leetcode.editor.cn;
  
  
public class LongestPalindromicSubstring{

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 		执行耗时:258 ms,击败了25.96% 的Java用户
         * 		内存消耗:42.2 MB,击败了30.75% 的Java用户
         */
 /*   public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int left = 0;
        int right = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j-i > right-left) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
    }*/

        /**
         * 		执行耗时:228 ms,击败了28.76% 的Java用户
         * 		内存消耗:38.7 MB,击败了69.05% 的Java用户
         */
/*    public String longestPalindrome(String s) {
        boolean[] dp = new boolean[s.length()];
        int left = 0;
        int right = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i < 3) {
                        dp[i] = true;
                    } else {
                        dp[i] = dp[i+1];
                    }
                } else {
                    dp[i] = false;
                }
                if (dp[i] && j-i > right-left) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
    }*/

        /**
         * 		执行耗时:33 ms,击败了80.81% 的Java用户
         * 		内存消耗:39.2 MB,击败了53.66% 的Java用户
         */
/*    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }*/

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}