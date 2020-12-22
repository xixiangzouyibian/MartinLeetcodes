//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 354 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
       Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
/*    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.pollLast();
                row.add(node.val);
                if (node.left != null) queue.push(node.left);
                if (node.right != null) queue.push(node.right);
            }
            if (ans.size() > 0 && (ans.size()-1) % 2 == 0) {
                Collections.reverse(row);
            }
            ans.add(row);
        }
        return ans;
    }*/

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        travel(root, ans, 0);
        return ans;
    }

    private void travel(TreeNode node, List<List<Integer>> ans, int level) {
        if (node == null) return;

        if (ans.size() <= level) {
            List<Integer> newRow = new ArrayList<>();
            ans.add(newRow);
        }
        List<Integer> row = ans.get(level);
        if (level % 2 == 1) {
            row.add(0, node.val);
        } else {
            row.add(node.val);
        }
        travel(node.left, ans, level+1);
        travel(node.right, ans, level+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
