//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 497 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
       Solution solution = new Combinations().new Solution();
        System.out.println(solution.combine(5,3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, 0, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int level, int k, int start, List<Integer> item, List<List<Integer>> res) {
        if (level == k) {
            res.add(new ArrayList<>(item));
            return;
        }

        if (start+(k-level)-1 > n) { // if the remaining nums are not enough for selecting, just return
            return;
        }

        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, level+1, k, i+1, item, res);
            item.remove(item.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
