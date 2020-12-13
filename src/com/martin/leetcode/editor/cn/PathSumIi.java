//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 391 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class PathSumIi{
    public static void main(String[] args) {
       Solution solution = new PathSumIi().new Solution();
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allPath = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, allPath, path, sum);
        return allPath;
    }

    public void pathSum(TreeNode node, List<List<Integer>> allPath, List<Integer> path, int sum) {
        if (node == null) return;
        path.add(node.val);

        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                allPath.add(new ArrayList<>(path));
            }
        }
        pathSum(node.left, allPath, path, sum-node.val);
        pathSum(node.right, allPath, path, sum-node.val);

        path.remove(path.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
