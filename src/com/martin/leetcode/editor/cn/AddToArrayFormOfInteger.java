//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。 
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 示例 4： 
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 0 <= A[i] <= 9 
// 0 <= K <= 10000 
// 如果 A.length > 1，那么 A[0] != 0 
// 
// Related Topics 数组 
// 👍 107 👎 0


package com.martin.leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger{
    public static void main(String[] args) {
       Solution solution = new AddToArrayFormOfInteger().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length-1;
        LinkedList<Integer> ans = new LinkedList<>();;
        boolean carry = false;
        while (len >= 0 || K > 0) {
            int arrayNum = len >= 0 ? A[len] : 0;
            int KNum = K > 0 ? K % 10 : 0;
            int sum = carry ? arrayNum + KNum + 1 : arrayNum + KNum;
            if (sum > 9) {
                ans.addFirst(sum % 10);
                carry = true;
            } else {
                ans.addFirst(sum);
                carry = false;
            }
            len--;
            K /= 10;
        }
        if (carry) {
            ans.add(0, 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
