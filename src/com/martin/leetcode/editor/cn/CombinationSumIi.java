//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 491 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi{
    public static void main(String[] args) {
       Solution solution = new CombinationSumIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), res);

        return res;
    }

    private void dfs(int[] candidates, int start, int target, List<Integer> item, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(item));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target-candidates[i] < 0) {
                break;
            }

            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }

            item.add(candidates[i]);
            dfs(candidates, i+1, target-candidates[i], item, res);
            item.remove(item.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
