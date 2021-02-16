//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1560 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
       Solution solution = new GenerateParentheses().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(new StringBuilder(), n, n, res);
        return res;
    }

    private void dfs(StringBuilder format, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(format.toString());
            return;
        }

        if (left > right) return;

        if (left > 0) {
            format.append("(");
            dfs(format, left-1, right, res);
            format.deleteCharAt(format.length()-1);
        }

        if (right > 0) {
            format.append(")");
            dfs(format, left, right-1, res);
            format.deleteCharAt(format.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
