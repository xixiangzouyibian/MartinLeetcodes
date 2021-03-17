//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 877 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak{
    public static void main(String[] args) {
       Solution solution = new WordBreak().new Solution();
        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

/*    public boolean wordBreak(String s, List<String> wordDict) {
        s += " ";
        int len = s.length();
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len-1];
    }*/

/*    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String w : wordDict) {
            trie.insert(w);
        }

        int len = s.length();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[len];
        queue.offer(0);
        visit[0] = true;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            List<Integer> next = trie.search(s, index);
            for (int n : next) {
                if (n == len-1) return true;
                if (!visit[n+1]) {
                    queue.offer(n+1);
                    visit[n+1] = true;
                }
            }
        }
        return false;
    }

    class Trie {
        TrieNode root;

        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            boolean isWord = false;
        }

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            for (char c : chars) {
                if (cur.next[c-'a'] == null) {
                    cur.next[c-'a'] = new TrieNode();
                }
                cur = cur.next[c-'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            for (char c : chars) {
                if (cur.next[c-'a'] == null) return false;
                cur = cur.next[c-'a'];
            }
            return cur != null && cur.isWord;
        }

        public List<Integer> search(String s, int prefixIndex) {
            TrieNode cur = root;
            int start = prefixIndex;
            List<Integer> res = new ArrayList<>();
            int len = s.length();
            while (start < len) {
                char c = s.charAt(start);
                if (cur.next[c-'a'] == null) return res;
                cur = cur.next[c-'a'];
                if (cur.isWord) res.add(start);
                start++;
            }
            return res;
        }
    }*/

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<Long> word2Hash = new HashSet<>();
        for (String w : wordDict) {
            long h = 0;
            for (char c : w.toCharArray()) {
                h = h * 131 + c;
            }
            word2Hash.add(h);
        }
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        s = " " + s;
        for (int i = 0; i < len; i++) {
            if (dp[i]) {
                long h = 0;
                for (int j = i+1; j <= len; j++) {
                    h = h * 131 + s.charAt(j);
                    if (word2Hash.contains(h)) dp[j] = true;
                }
            }
        }
        return dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
