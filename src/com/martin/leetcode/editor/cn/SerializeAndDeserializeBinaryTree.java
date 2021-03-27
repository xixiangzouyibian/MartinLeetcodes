//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 104] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 设计 
// 👍 526 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
//       Solution solution = new SerializeAndDeserializeBinaryTree().new Solution();
    }

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
/*public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return String.join(",", res);
    }

    private void dfs(TreeNode root, List<String> res) {
        if (root == null) {
            res.add("X");
            return;
        }
        res.add(String.valueOf(root.val));
        dfs(root.left, res);
        dfs(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return build(nodes);
    }
    int index = 0;
    private TreeNode build(String[] nodes) {
        if (index >= nodes.length || nodes[index].equals("X")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
        ++index;
        root.left = build(nodes);
        ++index;
        root.right = build(nodes);
        return root;
    }
}*/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    res.add(String.valueOf(node.val));
                    queue.add(node.left);
                    queue.offer(node.right);
                } else {
                    res.add("X");
                }
            }
        }
        return String.join(",",res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int cur = 0;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            String lV = nodes[++cur];
            if (!"X".equals(lV)) {
                curNode.left = new TreeNode(Integer.parseInt(lV));
                queue.offer(curNode.left);
            }
            String rV = nodes[++cur];
            if (!"X".equals(rV)) {
                curNode.right = new TreeNode(Integer.parseInt(rV));
                queue.offer(curNode.right);
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
