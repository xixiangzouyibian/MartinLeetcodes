//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返
//回答案中字典序最小的单词。 
//
// 若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：
//words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
// 
//
// 示例 2： 
//
// 输入：
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释：
//"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
// 
//
// 
//
// 提示： 
//
// 
// 所有输入的字符串都只包含小写字母。 
// words数组长度范围为[1,1000]。 
// words[i]的长度范围为[1,30]。 
// 
// Related Topics 字典树 哈希表 
// 👍 120 👎 0


package com.martin.leetcode.editor.cn;


public class LongestWordInDictionary{
    public static void main(String[] args) {
       Solution solution = new LongestWordInDictionary().new Solution();
        System.out.println(solution.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    TrieNode root = new TrieNode();

    int longestDepth = 0;
    String res = "";

    public String longestWord(String[] words) {
        int len = words.length;
        for (int i = 0; i < len; i++) {
            insert(words[i]);
        }
        find(root, 0);
        return res;
    }

    public void insert(String word) {
        int len = word.length();
        TrieNode cur = root;
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            if (cur.nodes[index] == null) {
                cur.nodes[index] = new TrieNode();
            }
            cur = cur.nodes[index];
        }
        cur.content = word;
        cur.isEnd = true;
    }

    public void find(TrieNode root, int depth) {
        if (root == null || (!root.isEnd && depth != 0)) return;
        if (depth > longestDepth) {
            longestDepth = depth;
            res = root.content;
        }
        for (TrieNode next : root.nodes) {
            find(next, depth+1);
        }
    }

    class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        String content;
        boolean isEnd = false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
