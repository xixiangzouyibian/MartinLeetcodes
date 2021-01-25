//给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。 
//
// 
//
// 示例 1： 
//
// 输入：["abcd","dcba","lls","s","sssll"]
//输出：[[0,1],[1,0],[3,2],[2,4]] 
//解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 示例 2： 
//
// 输入：["bat","tab","cat"]
//输出：[[0,1],[1,0]] 
//解释：可拼接成的回文串为 ["battab","tabbat"] 
// Related Topics 字典树 哈希表 字符串 
// 👍 209 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs{
    public static void main(String[] args) {
       Solution solution = new PalindromePairs().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    TrieNode root = new TrieNode();

    public List<List<Integer>> palindromePairs(String[] words) {
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String word = new StringBuilder(words[i]).reverse().toString();
            TrieNode cur = root;

            if (isPalindrome(word)) {
                cur.suffix.add(i);
            }

            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';
                if (cur.node[index] == null) {
                    cur.node[index] = new TrieNode();
                }
                cur = cur.node[index];
                if (isPalindrome(word.substring(j+1))) {
                    cur.suffix.add(i);
                }
            }
            cur.index = i;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String word = words[i];
            TrieNode cur = root;

            int j = 0;
            for (; j < word.length(); j++) {
                if (isPalindrome(word.substring(j)) && cur.index != -1) {
                    res.add(Arrays.asList(i, cur.index));
                }
                int index = word.charAt(j) - 'a';
                if (cur.node[index] == null) break;
                cur = cur.node[index];
            }

            if (j == word.length()) {
                for (int s : cur.suffix) {
                    if (s != i) {
                        res.add(Arrays.asList(i, s));
                    }
                }
            }
        }

        return res;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    class TrieNode {
        TrieNode[] node = new TrieNode[26];
        int index = -1;
        List<Integer> suffix = new ArrayList<>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
