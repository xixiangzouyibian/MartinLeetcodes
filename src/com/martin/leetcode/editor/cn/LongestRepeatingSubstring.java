//给定字符串 S，找出最长重复子串的长度。如果不存在重复子串就返回 0。 
//
// 
//
// 示例 1： 
//
// 输入："abcd"
//输出：0
//解释：没有重复子串。
// 
//
// 示例 2： 
//
// 输入："abbaba"
//输出：2
//解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
// 
//
// 示例 3： 
//
// 输入："aabcaabdaab"
//输出：3
//解释：最长的重复子串为 "aab"，出现 3 次。
// 
//
// 示例 4： 
//
// 输入："aaaaa"
//输出：4
//解释：最长的重复子串为 "aaaa"，出现 2 次。 
//
// 
//
// 提示： 
//
// 
// 字符串 S 仅包含从 'a' 到 'z' 的小写英文字母。 
// 1 <= S.length <= 1500 
// 
// Related Topics 字符串 
// 👍 43 👎 0


package com.martin.leetcode.editor.cn;


public class LongestRepeatingSubstring{
    public static void main(String[] args) {
       Solution solution = new LongestRepeatingSubstring().new Solution();
        System.out.println(solution.longestRepeatingSubstring("abbaba"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int longestRepeatingSubstring(String S) {
        int l = 0;
        int r = S.length() - 1;

        while (l < r) {
            int mid = (l + r + 1)  / 2;
            if (checked(S, mid)) {
                l = mid;
            } else {
                r = mid-1;
            }
        }
        return l;
    }

    private boolean checked(String s, int len) {
        Set<String> log = new HashSet<>();
        for (int i = 0; i <= s.length() - len; i++) {
            String sS = s.substring(i, i+len);
            if (log.contains(sS)) {
                return true;
            }
            log.add(sS);
        }
        return false;
    }*/

/*    public int longestRepeatingSubstring(String S) {
        int len = S.length();
        int[][] dp = new int[len][len];
        int longest = 0;

        //init
        for (int i = 1; i < len; i++) {
            if (S.charAt(0) == S.charAt(i)) {
                dp[0][i] = 1;
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (S.charAt(i) == S.charAt(j) && i != j) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    longest = Math.max(longest, dp[i][j]);
                }
            }
        }
        return longest;
    }*/

    public int longestRepeatingSubstring(String S) {
        int len = S.length();
        int[][] dp = new int[len][len];
        int longest = 0;

        //init
        for (int i = 1; i < len; i++) {
            if (S.charAt(0) == S.charAt(i)) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (S.charAt(i) == S.charAt(j) && i != j) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    longest = Math.max(longest, dp[i][j]);
                }
            }
        }
        return longest;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
