//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: "()())()"
//输出: ["()()()", "(())()"]
// 
//
// 示例 2: 
//
// 
//输入: "(a)())()"
//输出: ["(a)()()", "(a())()"]
// 
//
// 示例 3: 
//
// 
//输入: ")("
//输出: [""] 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 395 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveInvalidParentheses{
    public static void main(String[] args) {
       Solution solution = new RemoveInvalidParentheses().new Solution();
        System.out.println(solution.removeInvalidParentheses("()())()"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                r++;
            }
        }
        int max = Math.min(l, r);
        dfs(0, max, "", chars, 0, chars.length);
        return res.stream().filter(ss -> ss.length() == total).collect(Collectors.toList());
    }

    Set<String> res = new HashSet<>();
    int total = 0;
    private void dfs(int score, int max, String ss, char[] chars, int start, int len) {
        if (start == len) {
            if (score == 0 && ss.length() >= total) {
                total = Math.max(ss.length(), total);
                res.add(ss);
            }
            return;
        }
        if (chars[start] == '(') {
            if (score + 1 <= max) dfs(score+1, max, ss+"(", chars, start+1, len);
            dfs(score, max, ss, chars, start+1, len);
        } else if (chars[start] == ')') {
            if (score > 0) dfs(score-1, max, ss+")", chars, start+1, len);
            dfs(score, max, ss, chars, start+1, len);
        } else {
            dfs(score, max, ss+chars[start], chars, start+1, len);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
