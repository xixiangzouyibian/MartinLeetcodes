//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 591 👎 0


package com.martin.leetcode.editor.cn;


import java.util.*;

public class PermutationsIi{
    public static void main(String[] args) {
       Solution solution = new PermutationsIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        Arrays.sort(nums);
        dfs(nums, 0, len, new boolean[len], new ArrayDeque<>(), res);

        return res;
    }

    private void dfs(int[] nums, int level, int len, boolean[] visited, Deque<Integer> item, List<List<Integer>> res) {
        if (level == len) {
            res.add(new ArrayList<>(item));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) {
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
