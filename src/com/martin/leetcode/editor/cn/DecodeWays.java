//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 题目数据保证答案肯定是一个 32 位的整数。 
//
// 
//
// 示例 1： 
//
// 输入："12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 输入："226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 输入：s = "0"
//输出：0
// 
//
// 示例 4： 
//
// 输入：s = "1"
//输出：1
// 
//
// 示例 5： 
//
// 输入：s = "2"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可以包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 519 👎 0

  
package com.martin.leetcode.editor.cn;
  
  
public class DecodeWays{

    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        System.out.println(solution.numDecodings("2101"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }*/

    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;

        int len = s.length();
        s = " " +s;
        char[] chars = s.toCharArray();
        int[] dp = new int[len+1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (chars[i] >= '1' && chars[i] <= '9') dp[i] += dp[i-1];
            if (i > 1) {
                int t = (chars[i-1] - '0') * 10 + chars[i] - '0';
                if (t >= 10 && t <= 26) dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}