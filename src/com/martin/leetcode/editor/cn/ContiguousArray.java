//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 哈希表 
// 👍 390 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class ContiguousArray{
    public static void main(String[] args) {
       Solution solution = new ContiguousArray().new Solution();
        System.out.println(solution.findMaxLength(new int[] {0,1,0}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len+1];
        for (int i = 0; i < len; i++) pre[i+1] = pre[i] + (nums[i] == 1 ? 1 : -1);

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i <= len; i++) {
            if (!map.containsKey(pre[i-2])) map.put(pre[i-2], i-2);
            if (map.containsKey(pre[i]))
                res = Math.max(res, i - map.get(pre[i]));
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
