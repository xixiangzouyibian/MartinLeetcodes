//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 263 👎 0


package com.martin.leetcode.editor.cn;


public class SumOfSquareNumbers{
    public static void main(String[] args) {
       Solution solution = new SumOfSquareNumbers().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public boolean judgeSquareSum(int c) {
        int hi = (int) Math.sqrt(c);

        for (int a = 0; a <= hi; a++) {
            int b = (int) Math.sqrt(c - a * a);
            if (a * a + b * b == c) return true;
        }
        return false;
    }*/

    public boolean judgeSquareSum(int c) {
        int lo = 0, hi = (int) Math.sqrt(c);
        while (lo <= hi) {
            int cur = lo * lo + hi * hi;
            if (cur == c) {
                return true;
            } else if (cur < c) {
                lo++;
            } else {
                hi--;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
