//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。 
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈 
// 👍 227 👎 0


package com.martin.leetcode.editor.cn;


public class VerifyPreorderSerializationOfABinaryTree{
    public static void main(String[] args) {
       Solution solution = new VerifyPreorderSerializationOfABinaryTree().new Solution();
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * DFS
         */
/*    int index = 0;
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int len = nodes.length;
        return dfs(nodes, len) && index == len;
    }

    private boolean dfs(String[] nodes, int len) {
        if (index == len) return false;
        if (nodes[index++].equals("#")) return true;

        boolean left = dfs(nodes, len);
        boolean right = dfs(nodes, len);
        return left && right;
    }*/

        /**
         * Stack
         */
/*    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        stack.push("");
        String[] nodes = preorder.split(",");
        for (String node : nodes) {
            while (!stack.isEmpty() && stack.peek().equals("#") && node.equals("#")) {
                stack.pop();
                stack.pop();
                if (stack.isEmpty()) return false;
                node = "#";
            }
            stack.push(node);
        }
        return stack.size() == 2 && stack.peek().equals("#");
    }*/

        /**
         * Graph
         */
    public boolean isValidSerialization(String preorder) {
        int in = 0, out = 1;
        for (String node : preorder.split(",")) {
            if (out <= in) return false;
            in++;
            if (!node.equals("#")) {
                out += 2;
            }
        }
        return in == out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
