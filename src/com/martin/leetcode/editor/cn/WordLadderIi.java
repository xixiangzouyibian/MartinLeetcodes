//按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s
//1 -> s2 -> ... -> sk 这样的单词序列，并满足： 
//
// 
// 
// 
// 每对相邻的单词之间仅有单个字母不同。 
// 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单
//词。 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的
// 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//解释：存在 2 种最短的转换序列：
//"hit" -> "hot" -> "dot" -> "dog" -> "cog"
//"hit" -> "hot" -> "lot" -> "log" -> "cog"
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：[]
//解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 7 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有单词 互不相同 
// 
// 
// 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 427 👎 0


package com.martin.leetcode.editor.cn;


import java.util.*;

public class WordLadderIi{
    public static void main(String[] args) {
       Solution solution = new WordLadderIi().new Solution();
        System.out.println(solution.findLadders("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        HashMap<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 0);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (int i = 0; i < cur.length(); i++) {
                char[] cc = cur.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    cc[i] = j;
                    String next = new String(cc);
                    if (set.contains(next) && !dist.containsKey(next)) {
                        dist.put(next, dist.get(cur) + 1);
                        if (next.equals(endWord)) break;
                        queue.offer(next);
                    }
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        if (!dist.containsKey(endWord)) return res;

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, dist, path, res);
        return res;
    }

    private void dfs(String startW, String endW,
                     HashMap<String, Integer> dist,
                     List<String> path, List<List<String>> res) {
        if (startW.equals(endW)) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < startW.length(); i++) {
            char[] cc = startW.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
                cc[i] = j;
                String next = new String(cc);
                if (dist.containsKey(next) &&
                    dist.get(next) == dist.get(startW) + 1) {
                    path.add(next);
                    dfs(next, endW, dist, path, res);
                    path.remove(path.size()-1);
                }
            }
        }
    }
}*/

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        HashMap<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 0);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        HashMap<String, Set<String>> adjacent = new HashMap<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                Set<String> follows = adjacent.getOrDefault(cur, new HashSet<>());
                adjacent.put(cur, follows);
                for (int i = 0; i < cur.length(); i++) {
                    char[] cc = cur.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        cc[i] = j;
                        String next = new String(cc);
                        if (set.contains(next) && !dist.containsKey(next)) {
                            dist.put(next, dist.get(cur) + 1);
                            queue.offer(next);
                        }
                        follows.add(next);
                    }
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        if (!dist.containsKey(endWord)) return res;

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, dist, adjacent, path, res);
        return res;
    }

    private void dfs(String startW, String endW,
                     HashMap<String, Integer> dist,
                     HashMap<String, Set<String>> adjacent,
                     List<String> path, List<List<String>> res) {
        if (startW.equals(endW)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String next : adjacent.get(startW)) {
            if (dist.containsKey(next) &&
                    dist.get(next) == dist.get(startW) + 1) {
                path.add(next);
                dfs(next, endW, dist, adjacent, path, res);
                path.remove(path.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
