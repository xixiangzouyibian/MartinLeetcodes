//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 282 👎 0

  
package com.martin.leetcode.editor.cn;
  
  
public class ValidPalindromeIi{

    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        System.out.println(solution.validPalindrome("abc"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return _isValid(s, i+1, j) || _isValid(s, i, j-1);
            }
        }
        return true;
    }

    private boolean _isValid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }*/

    public boolean validPalindrome(String s) {
        return _isValid(s, 0, s.length()-1, 1);
    }

    private boolean _isValid(String s, int start, int end, int times) {
        if (start >= end) return true;

        if (s.charAt(start) != s.charAt(end)) {
            if (times == 0) {
                return false;
            } else {
                return _isValid(s, start+1, end, times-1) || _isValid(s, start, end-1, times-1);
            }
        }
        return _isValid(s, start+1, end-1, times);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}