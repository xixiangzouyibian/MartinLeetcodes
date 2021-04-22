//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 738 👎 0


package com.martin.leetcode.editor.cn;


import java.util.*;

public class WordLadder{
    public static void main(String[] args) {
       Solution solution = new WordLadder().new Solution();
        System.out.println(solution.ladderLength("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*        List<List<String>> res;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();
        if (!wordList.contains(endWord)) return 0;

        dfs(beginWord, endWord, wordList, new ArrayList<>(), new HashSet<>());

        int ans = Integer.MAX_VALUE;
        for (List<String> r : res) {
            ans = Math.min(ans, r.size());
        }

        return ans == Integer.MAX_VALUE ? 0 : ans + 1;
    }

    private void dfs(String startWord, String endWord, List<String> wordList, List<String> tmp, Set<String> visit) {
        if (startWord.equals(endWord)) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (String w : wordList) {
            if (visit.contains(w)) continue;
            if (check(startWord, w)) {
                visit.add(w);
                tmp.add(w);
                dfs(w, endWord, wordList, tmp, visit);
                visit.remove(w);
                tmp.remove(tmp.size()-1);
            }
        }
    }*/

/*    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        int len = wordList.size();
        String[] words = new String[len];
        wordList.toArray(words);
        boolean[] visit = new boolean[len];

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                if (endWord.equals(curWord)) return res;
                for (int j = 0; j < len; j++) {
                    if (!visit[j] && check(curWord, words[j])) {
                        visit[j] = true;
                        queue.offer(words[j]);
                    }
                }
            }
            res++;
        }
        return 0;
    }

    private boolean check(String w1, String w2) {
        if (w1.length() != w2.length()) return false;

        char[] w1c = w1.toCharArray();
        char[] w2c = w2.toCharArray();

        int cnt = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1c[i] != w2c[i]) cnt++;
            if (cnt >= 2) return false;
        }

        return cnt == 1;
    }*/

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Set<String> visit = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList); // important
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                char[] cc = curWord.toCharArray();
                for (int j = 0; j < cc.length; j++) {
                    char backup = cc[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cc[j] = c;
                        String rWord = new String(cc);
                        if (dict.contains(rWord) && !visit.contains(rWord)) {
                            if (rWord.equals(endWord)) return res+1;
                            visit.add(rWord);
                            queue.offer(rWord);
                        }
                    }
                    cc[j] = backup;
                }
            }
            res++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
