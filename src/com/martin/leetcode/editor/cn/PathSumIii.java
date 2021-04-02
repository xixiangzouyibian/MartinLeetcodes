//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 799 👎 0


package com.martin.leetcode.editor.cn;


public class PathSumIii{
    public static void main(String[] args) {
       Solution solution = new PathSumIii().new Solution();
    }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
/*    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> pre = new HashMap<>();
        pre.put(0, 1);
        return dfs(root, sum, 0, pre);
    }

    private int dfs(TreeNode root, int sum, int curSum, Map<Integer, Integer> pre) {
        if (root == null) return 0;

        int res = 0;
        curSum += root.val;
        System.out.println(curSum);

        res += pre.getOrDefault(curSum - sum, 0);
        pre.put(curSum, pre.getOrDefault(curSum, 0) + 1);

        res += dfs(root.left, sum, curSum, pre);
        res += dfs(root.right, sum, curSum, pre);

        pre.put(curSum, pre.get(curSum)-1);

        return res;
    }*/

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;

        sum -= root.val;
        int res = sum == 0 ? 1 : 0;
        return res + dfs(root.left, sum) + dfs(root.right, sum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
