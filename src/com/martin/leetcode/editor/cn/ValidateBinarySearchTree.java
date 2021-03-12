//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 957 👎 0


package com.martin.leetcode.editor.cn;


public class ValidateBinarySearchTree{
    public static void main(String[] args) {
       Solution solution = new ValidateBinarySearchTree().new Solution();
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
/*    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;

        if (pre >= root.val) return false;
        pre = root.val;

        return isValidBST(root.right);
    }*/

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root) {
        int[] res = new int[] {1, root.val, root.val};
        if (root.left != null) {
            int[] l = dfs(root.left);
            if (l[0] == 0 || l[2] >= root.val) res[0] = 0;
            res[1] = Math.min(res[1], l[1]);
            res[2] = Math.max(res[2], l[2]);
        }
        if (root.right != null) {
            int[] r = dfs(root.right);
            if (r[0] == 0 || root.val >= r[1]) res[0] = 0;
            res[1] = Math.min(res[1], r[1]);
            res[2] = Math.max(res[2], r[2]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
