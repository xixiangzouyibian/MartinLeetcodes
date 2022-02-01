//English description is not available for the problem. Please switch to 
//Chinese. Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 259 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class XuLieHuaErChaShuLcof{

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*public class Codec {

        private static final String NVL = "NVL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        List<String> record = new ArrayList<>();
        queue.add(root);
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
        if (data.equals("")) return null;
        String[] dd = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dd[0]));
        Queue<TreeNode> queue = new LinkedList<>();
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
}*/

public class Codec {

    private static final String NVL = "NVL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        seDFS(root, builder);
        return builder.toString();
    }

    private void seDFS(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(NVL).append("#");
        } else {
            builder.append(node.val).append("#");
            seDFS(node.left, builder);
            seDFS(node.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        List<String> dd = Arrays.stream(data.split("#"))
                .collect(Collectors.toCollection(LinkedList::new));
        return deDFS(dd);
    }

    private TreeNode deDFS(List<String> dd) {
        if (dd.get(0).equals(NVL)) {
            dd.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dd.get(0)));
        dd.remove(0);
        root.left = deDFS(dd);
        root.right = deDFS(dd);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}