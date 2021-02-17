//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1133 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permutations{
    public static void main(String[] args) {
       Solution solution = new Permutations().new Solution();
       solution.permute(new int[] {1,2,3});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        dfs(nums, 0, len, new boolean[len], new ArrayDeque<>(), res);

        return res;
    }

/*    private void dfs(int[] nums, List<Integer> item, List<List<Integer>> res) {
        // if all is selected, return
        if (item.size() == nums.length) {
            res.add(new ArrayList<>(item));
            return;
        }

        for (Integer cur : nums) {
            if (item.contains(cur)) {
                continue;
            }
            item.add(cur);
            dfs(nums, item, res);
            item.remove(cur); // item.remove(item.size()-1)
        }
    }*/

    private void dfs(int[] nums, int level, int len, boolean[] visited, Deque<Integer> item, List<List<Integer>> res) {
        if (level == len) {
            res.add(new ArrayList<>(item));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            item.push(nums[i]);
            visited[i] = true;
            dfs(nums, level+1, len, visited, item, res);
            item.pop();
            visited[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
