//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 1024 👎 0


package com.martin.leetcode.editor.cn;


public class UniqueBinarySearchTrees{
    public static void main(String[] args) {
       Solution solution = new UniqueBinarySearchTrees().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }*/

    public int numTrees(int n) {
        return getNum(1, n, new int[n]);
    }

    public int getNum(int l, int r, int[] memory) {
        if (l >= r) return 1;
        if (memory[r-l] != 0) return memory[r-l];
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += getNum(l, i-1, memory) * getNum(i+1, r, memory);
        }
        memory[r-l] = sum;
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
