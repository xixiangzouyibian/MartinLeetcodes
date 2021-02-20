//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 数学 回溯算法 
// 👍 471 👎 0


package com.martin.leetcode.editor.cn;


public class PermutationSequence{
    public static void main(String[] args) {
       Solution solution = new PermutationSequence().new Solution();
        System.out.println(solution.getPermutation(4, 9));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public String getPermutation(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 0, new boolean[n+1], new ArrayList<>(), res);
        StringBuilder stringBuilder = new StringBuilder();
        res.get(res.size()-1).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    private void dfs(int n, int k, int level, boolean[] visited, List<Integer> item, List<List<Integer>> res) {
        if (res.size() == k) {
            return;
        }
        if (level == n) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            item.add(i);
            dfs(n, k, level+1, visited, item, res);
            item.remove(item.size()-1);
            visited[i] = false;
        }
    }*/

    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        boolean[] visited = new boolean[n+1];
        for (int bit = 0; bit < n; bit++) {
            int fact = 1;
            for (int i = 1; i <= n-bit-1; i++) {
                fact *= i;
            }
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    if (fact < k) {
                        k -= fact;
                    } else {
                        res.append(j);
                        visited[j] = true;
                        break;
                    }
                }

            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
