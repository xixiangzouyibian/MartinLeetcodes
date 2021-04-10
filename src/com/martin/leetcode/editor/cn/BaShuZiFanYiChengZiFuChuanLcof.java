//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 208 👎 0


package com.martin.leetcode.editor.cn;


public class BaShuZiFanYiChengZiFuChuanLcof{
    public static void main(String[] args) {
       Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        System.out.println(solution.translateNum(25));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        char[] c = (" " + num).toCharArray();
        int len = c.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1];
            if (i > 1 && (c[i-1] - '0') > 0 && (c[i-1] - '0') * 10 + (c[i] - '0') <= 25) {
                dp[i] += dp[i-2];
            }
        }
        return dp[len-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
