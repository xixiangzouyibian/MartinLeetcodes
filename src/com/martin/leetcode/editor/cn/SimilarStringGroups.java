//如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。 
//
//
// 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "t
//ars"，"rats"，或 "arts" 相似。 
//
// 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同
//一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。 
//
// 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？ 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["tars","rats","arts","star"]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：strs = ["omv","ovm"]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 100 
// 1 <= strs[i].length <= 1000 
// sum(strs[i].length) <= 2 * 104 
// strs[i] 只包含小写字母。 
// strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。 
// 
//
// 
//
// 备注： 
//
// 字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。 
// Related Topics 深度优先搜索 并查集 图 
// 👍 65 👎 0


package com.martin.leetcode.editor.cn;


public class SimilarStringGroups{
    public static void main(String[] args) {
       Solution solution = new SimilarStringGroups().new Solution();
        System.out.println(solution.numSimilarGroups(new String[] {"tars","rats","arts","star"}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (check(strs[i], strs[j])) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }

    public boolean check(String a, String b) {
        if (a.equals(b)) return true;
        int num = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }

*//*    public boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int count = 0;
        int compare = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) count++;

            compare ^= c1;
            compare ^= c2;

        }
        return count == 2 && compare == 0;
    }*//*

    class UnionFind {
        int[] p;
        int count;
        public UnionFind(int len) {
            p = new int[len];
            count = len;
            for (int i = 0; i < len; i++) {
                p[i] = i;
            }
        }
        public int find(int id) {
            if (p[id] != id) {
                p[id] = find(p[id]);
            }
            return p[id];
        }
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                p[xRoot] = yRoot;
                count--;
            }
        }
    }
}*/
class Solution {
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        boolean[] visited = new boolean[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            dfs(i, strs, visited);
            ans++;
        }
        return ans;
    }

    public void dfs(int cur, String[] strs, boolean[] visited) {
        if (!visited[cur]) {
            visited[cur] = true;
            for (int i = 0; i < strs.length; i++) {
                if (visited[i]) continue;
                if (check(strs[cur], strs[i])) {
                    dfs(i, strs, visited);
                }
            }
        }
    }

    public boolean check(String a, String b) {
        if (a.equals(b)) return true;
        int num = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
