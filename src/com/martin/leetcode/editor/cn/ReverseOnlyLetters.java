//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 字符串 
// 👍 66 👎 0

  
package com.martin.leetcode.editor.cn;
  
  
public class ReverseOnlyLetters{

    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
        System.out.println(solution.reverseOnlyLetters("7_28]"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) return "";
        int i = 0, j = S.length() - 1;
        char[] chars = S.toCharArray();
        while (i < j) {
            while (i < S.length() && !Character.isAlphabetic(chars[i])) i++;
            while (j >= 0 && !Character.isAlphabetic(chars[j])) j--;
            if (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }*/

    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (!Character.isLetter(chars[i])) {
                i++;
            } else if (!Character.isLetter(chars[j])) {
                j--;
            } else {
                char temp = chars[i]; chars[i] = chars[j]; chars[j] = temp;
                i++; j--;
            }
        }
        return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}