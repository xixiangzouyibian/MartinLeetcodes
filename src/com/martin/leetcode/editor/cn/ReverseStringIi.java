//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 101 👎 0

  
package com.martin.leetcode.editor.cn;
  
  
public class ReverseStringIi{

    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr("abcd", 2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public String reverseStr(String s, int k) {
        int start = 0;
        while (start < s.length()) {
            if (start + 2*k <= s.length()
                    || (start + 2*k > s.length() && start + k <= s.length())) {
                s = reverse(s, start, start+k);
            } else if (start + k > s.length()) {
                s = reverse(s, start, s.length());
            }
            start = start + 2*k;
        }
        return s;
    }

    public String reverse(String s, int start, int end) {
        return s.substring(0, start) + new StringBuilder(s.substring(start, end)).reverse().toString() + s.substring(end);
    }*/


    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}