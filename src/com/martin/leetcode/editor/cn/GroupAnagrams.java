//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 676 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams{
    public static void main(String[] args) {
       Solution solution = new GroupAnagrams().new Solution();
        System.out.println(solution.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] count = new int[26];
            for (char c : strs[i].toCharArray()) {
                count[c-'a']++;
            }
            map.put(i, count);
        }

        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            List<Integer> group = new ArrayList<>();
            dfs(i, len, group, map, visited);
            res.add(group.stream().map(index -> strs[index]).collect(Collectors.toList()));
        }
        return res;
    }

    private void dfs(int start, int len, List<Integer> group, Map<Integer, int[]> map, boolean[] visited) {
        if (start == len) return;
        if (!visited[start]) {
            if (group.size() == 0 || check(map.get(start), map.get(group.get(0)))) {
                visited[start] = true;
                group.add(start);
            }
        }
        dfs(start+1, len, group, map, visited);
    }

    private boolean check(int[] a1, int[] a2) {
        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }*/

/*    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String nStr = new String(chars);
            List<String> group = map.getOrDefault(nStr, new ArrayList<>());
            group.add(str);
            map.put(nStr, group);
        }
        return new ArrayList<>(map.values());
    }*/

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray())
                ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
