//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 385 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi{
    public static void main(String[] args) {
       Solution solution = new SubsetsIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(nums, 0, nums.length, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, int len, List<Integer> item, List<List<Integer>> res) {
        if (start == len) {
            return;
        }
        for (int i = start; i < len; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;

            item.add(nums[i]);
            res.add(new ArrayList<>(item));
            dfs(nums, i+1, len, item, res);
            item.remove(item.size()-1);
        }
    }*/

/*    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        res.add(new ArrayList<>());
        dfs(nums, 0, nums.length, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    private void dfs(int[] nums, int start, int len, List<Integer> item, Set<List<Integer>> res) {
        if (start == len) {
            res.add(new ArrayList<>(item));
            return;
        }
        item.add(nums[start]);
        dfs(nums, start+1, len, item, res);
        item.remove(item.size()-1);
        dfs(nums, start+1, len, item, res);
    }*/

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, nums.length, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, int len, List<Integer> item, List<List<Integer>> res) {
        if (start == len) {
            res.add(new ArrayList<>(item));
            return;
        }
        int cnt = 1;
        while (start+1 < len && nums[start] == nums[start+1]) {
            cnt++;
            start++;
        }

        dfs(nums, start+1, len, item, res);

        for (int i = 1; i <= cnt; i++) {
            item.add(nums[start]);
            dfs(nums, start+1, len, item, res);
        }
        for (int i = 1; i <= cnt; i++) {
            item.remove(item.size()-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
