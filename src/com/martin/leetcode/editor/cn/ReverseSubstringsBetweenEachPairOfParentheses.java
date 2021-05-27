//给出一个字符串 s（仅含有小写英文字母和括号）。 
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 输入：s = "(u(love)i)"
//输出："iloveu"
// 
//
// 示例 3： 
//
// 输入：s = "(ed(et(oc))el)"
//输出："leetcode"
// 
//
// 示例 4： 
//
// 输入：s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 我们确保所有括号都是成对出现的 
// 
// Related Topics 栈 
// 👍 175 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseSubstringsBetweenEachPairOfParentheses{
    public static void main(String[] args) {
       Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
        System.out.println(solution.reverseParentheses("(u(love)i)"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseParentheses(String s) {
        char[] cc = s.toCharArray();
        Deque<Character> st = new ArrayDeque<>();

        for (char c : cc) {
            if (c == ')') {
                Deque<Character> inner = new ArrayDeque<>();
                while (st.peek() != '(') {
                    inner.offer(st.pop());
                }
                st.pop();
                while (!inner.isEmpty()) st.push(inner.pop());
            } else {
                st.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!st.isEmpty()) {
            builder.append(st.pollLast());
        }
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
