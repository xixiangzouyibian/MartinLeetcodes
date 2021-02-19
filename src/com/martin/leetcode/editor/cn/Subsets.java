//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 996 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
       Solution solution = new Subsets().new Solution();
        System.out.println(solution.subsets(new int[] {1,2,3}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(nums, 0, 0, nums.length, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, int level, int len, List<Integer> item, List<List<Integer>> res) {
        if (level == len) {
            return;
        }

        for (int i = start; i < len; i++) {
            item.add(nums[i]);
            res.add(new ArrayList<>(item));
            dfs(nums, i+1, level+1, len, item, res);
            item.remove(item.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
