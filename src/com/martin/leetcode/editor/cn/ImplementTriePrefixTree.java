//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 507 👎 0


package com.martin.leetcode.editor.cn;


public class ImplementTriePrefixTree{
//    public static void main(String[] args) {
//       Solution solution = new ImplementTriePrefixTree().new Solution();
//    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    TrieNode root;

    class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isWord = false;
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            if (cur.nodes[index] == null) {  // it's important
                cur.nodes[index] = new TrieNode();
            }
            cur = cur.nodes[index];
        }
        cur.isWord = true;
    }

    private TrieNode searchTrieNode(String word) {
        TrieNode cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            TrieNode next = cur.nodes[index];
            if (next != null) {
                cur = next;
            } else {
                return null;
            }
        }
        return cur;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchTrieNode(word);
        return node != null && node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchTrieNode(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
