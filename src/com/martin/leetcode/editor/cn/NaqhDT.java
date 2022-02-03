//English description is not available for the problem. Please switch to 
//Chinese. 
//
// 
// 
// 
// Related Topics 树 广度优先搜索 设计 二叉树 👍 8 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class NaqhDT{

    //leetcode submit region begin(Prohibit modification and deletion)
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
/*class CBTInserter {

    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    private Object[] dfs(TreeNode node, int level) {
        if (node == null || node.left == null || node.right == null) {
            return new Object[] {node, level};
        }

        Object[] left = dfs(node.left, level+1);
        Object[] right = dfs(node.right, level+1);

        return (int)left[1] <= (int)right[1] ? left : right;
    }

    public int insert(int v) {
        TreeNode node = (TreeNode) dfs(root, 0)[0];
        if (node.left == null) {
            node.left = new TreeNode(v);
        } else {
            node.right = new TreeNode(v);
        }
        return node.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}*/

class CBTInserter {

    private Queue<TreeNode> queue;
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
    }

    public int insert(int v) {
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (node.left == null || node.right == null) {
                break;
            }
            queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        TreeNode node = queue.peek();
        if (node.left == null) {
            node.left = new TreeNode(v);
        } else {
            node.right = new TreeNode(v);
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
//leetcode submit region end(Prohibit modification and deletion)

}