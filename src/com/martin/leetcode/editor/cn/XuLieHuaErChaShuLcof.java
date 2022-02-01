//English description is not available for the problem. Please switch to 
//Chinese. Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 259 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class XuLieHuaErChaShuLcof{

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
public class Codec {

        private static final String NVL = "NVL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        LinkedList<String> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            } else {
                list.add(NVL);
            }
        }
        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] dd = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dd[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!dd[i].equals(NVL)) {
                node.left = new TreeNode(Integer.parseInt(dd[i]));
                queue.add(node.left);
            }
            i++;
            if (!dd[i].equals(NVL)) {
                node.right = new TreeNode(Integer.parseInt(dd[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}