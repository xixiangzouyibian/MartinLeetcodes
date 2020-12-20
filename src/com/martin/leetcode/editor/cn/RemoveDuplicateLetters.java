//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 394 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters{
    public static void main(String[] args) {
       Solution solution = new RemoveDuplicateLetters().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        if (len <= 1) return s;

        int[] count = new int[26];
        for (int m = 0; m < len; m++) count[s.charAt(m) - 'a']++;

        Deque<Character> stack = new ArrayDeque<>();
        boolean[] inStack = new boolean[26];
        for (int i = 0; i < len; i++) {
            char element = s.charAt(i);
            count[element-'a']--;

            if (inStack[element - 'a']) continue;

            while (!stack.isEmpty() && stack.peek() > element && count[stack.peek()-'a'] > 0) {
                char out = stack.poll();
                inStack[out - 'a'] = false;
            }
            stack.push(element);
            inStack[element - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) ans.append(stack.pollLast());
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
