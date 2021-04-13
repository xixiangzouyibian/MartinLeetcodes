//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 100] 内 
// 0 <= Node.val <= 105 
// 
// 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 171 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Stack;

public class MinimumDistanceBetweenBstNodes{
    public static void main(String[] args) {
       Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
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
/*    int pre = 100001;
    int res = 100001;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        dfs(node.left);
        res = Math.min(res, Math.abs(pre - node.val));
        pre = node.val;
        dfs(node.right);
    }*/

    public int minDiffInBST(TreeNode root) {
        int res = 100001;
        int pre = 100001;

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode cur = stack.pop();
            res = Math.min(res, Math.abs(pre-cur.val));
            pre = cur.val;
            root = cur.right;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
