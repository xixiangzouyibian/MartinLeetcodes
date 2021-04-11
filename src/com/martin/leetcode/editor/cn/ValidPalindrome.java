//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 365 👎 0


package com.martin.leetcode.editor.cn;


public class ValidPalindrome{
    public static void main(String[] args) {
       Solution solution = new ValidPalindrome().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        char[] cc = s.toCharArray();
        while (l < r) {
            if (!check(cc[l])) {
                l++;
                continue;
            }
            if (!check(cc[r])) {
                r--;
                continue;
            }

            if (cc[l] != cc[r] && (cc[l] ^ 32) != cc[r] && (cc[r] ^ 32) != cc[l]) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    private boolean check(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
