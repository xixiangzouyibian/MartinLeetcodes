//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,3,2]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [0,1,0,1,0,1,99]
//输出: 99 
// Related Topics 位运算 
// 👍 498 👎 0


package com.martin.leetcode.editor.cn;


public class SingleNumberIi{
    public static void main(String[] args) {
       Solution solution = new SingleNumberIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    count++;
                }
            }
            res = res | (count % 3 << i);
        }
        return res;
    }*/

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            int temp = a;
            a = (a & ~b & ~x) | (~a & b & x);
            b = (b ^ x) & ~temp;
        }
        return b; // 找到最后是01的状态(表示所有1模3余1的情况)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
