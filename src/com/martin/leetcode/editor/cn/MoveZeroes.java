//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 896 👎 0


package com.martin.leetcode.editor.cn;


public class MoveZeroes{
    public static void main(String[] args) {
       Solution solution = new MoveZeroes().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int count0 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                count0++;
                continue;
            }
            int temp = nums[i-count0];
            nums[i-count0] = nums[i];
            nums[i] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
