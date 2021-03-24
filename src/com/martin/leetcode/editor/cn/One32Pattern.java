//给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < a
//j。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。 
//
// 注意：n 的值小于15000。 
//
// 示例1: 
//
// 
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
// 
//
// 示例 2: 
//
// 
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
// 
//
// 示例 3: 
//
// 
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
// 
// Related Topics 栈 
// 👍 295 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class One32Pattern{
    public static void main(String[] args) {
       Solution solution = new One32Pattern().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean find132pattern(int[] nums) {
        return dfs(nums, 0, nums.length, new ArrayList<>());
    }

    private boolean dfs(int[] nums, int start, int len, List<Integer> comp) {
        if (comp.size() == 3) {
            return true;
        }

        if (start == len && comp.size() < 3) return false;

        for (int i = start; i < len; i++) {
            if (comp.size() == 1
                    && nums[comp.get(0)] >= nums[i])
                continue;
            if (comp.size() == 2
                    && !(nums[comp.get(0)] < nums[i] && nums[i] < nums[comp.get(1)]))
                continue;

            comp.add(i);
            if (dfs(nums, i+1, len, comp)) {
                return true;
            }
            comp.remove(comp.size()-1);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
