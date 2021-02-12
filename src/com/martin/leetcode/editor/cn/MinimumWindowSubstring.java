//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 939 👎 0


package com.martin.leetcode.editor.cn;


public class MinimumWindowSubstring{
    public static void main(String[] args) {
       Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println('z'-'A');
        System.out.println(solution.minWindow("cabwefgewcwaefgcf","cae"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[58];
        int countExpected = 0;
        for (char c : t.toCharArray()) {
            if (map[c-'A'] == 0) {
                countExpected++;
            }
            map[c-'A']++;
        }
        int l = 0, r = 0;
        int count = 0;
        int[] dir = new int[58];
        int start = 0;
        int minimum = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();
        while (r < s.length()) {
            int in = chars[r]-'A';
            if (map[in] > 0) {
                dir[in]++;
                if (dir[in] == map[in]) {
                    count++;
                }
            }
            while (count == countExpected) {
                int len = r-l+1;
                if (minimum > len) {
                    minimum = len;
                    start = l;
                }
                int out = chars[l]-'A';
                if (map[out] > 0) {
                    dir[out]--;
                    if (dir[out] < map[out]) {
                        count--;
                    }
                }
                l++;
            }
            r++;
        }
        return minimum == Integer.MAX_VALUE ? "" : s.substring(start, start+minimum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
