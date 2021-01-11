//给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。 
//
//
// 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。 
//
// 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。 
//
// 
//
// 示例 1: 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2]]
//输出："bacd"
//解释： 
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[1] 和 s[2], s = "bacd"
// 
//
// 示例 2： 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//输出："abcd"
//解释：
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[0] 和 s[2], s = "acbd"
//交换 s[1] 和 s[2], s = "abcd" 
//
// 示例 3： 
//
// 输入：s = "cba", pairs = [[0,1],[1,2]]
//输出："abc"
//解释：
//交换 s[0] 和 s[1], s = "bca"
//交换 s[1] 和 s[2], s = "bac"
//交换 s[0] 和 s[1], s = "abc"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s 中只含有小写英文字母 
// 
// Related Topics 并查集 数组 
// 👍 166 👎 0


package com.martin.leetcode.editor.cn;


import java.util.*;

public class SmallestStringWithSwaps{
    public static void main(String[] args) {
       Solution solution = new SmallestStringWithSwaps().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        int[] p = new int[len];
        for (int i = 0; i < len; i++) {
            p[i] = i;
        }

        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            int rootIndex1 = find(index1, p);
            int rootIndex2 = find(index2, p);
            p[rootIndex1] = rootIndex2;
        }

        Map<Integer, Queue<Character>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int root = find(i, p);
            map.computeIfAbsent(root, k -> new PriorityQueue<>()).offer(s.charAt(i));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(map.get(find(i, p)).poll());
        }
        return builder.toString();
    }

    private int find(int index, int[] p) {
        if (p[index] != index) {
            p[index] = find(p[index], p);
        }
        return p[index];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
