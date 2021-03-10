//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 469 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Stack;

public class BasicCalculator{
    public static void main(String[] args) {
       Solution solution = new BasicCalculator().new Solution();
        System.out.println(solution.calculate("- (3 + (4 + 5))"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        int res = 0, sign = 1, num = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = c == '+' ?  1 :  -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                num = 0;
                sign = 1;
            } else if (c == ')') {
                res += num * sign;
                int lastSign = stack.pop();
                int lastRes = stack.pop();
                res = lastSign * res + lastRes;
                num = 0;
                sign = 1;
            }
        }
        res += num * sign;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
