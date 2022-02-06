//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 23 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class H54YBf{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
public class Codec {

    private static final String NVL = "NVL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        List<String> record = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                record.add(NVL);
            } else {
                record.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return String.join(",", record);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] dd = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(dd[0]));
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!dd[++i].equals(NVL)) {
                node.left = new TreeNode(Integer.parseInt(dd[i]));
                queue.offer(node.left);
            }
            if (!dd[++i].equals(NVL)) {
                node.right = new TreeNode(Integer.parseInt(dd[i]));
                queue.offer(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}