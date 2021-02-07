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


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring{
    public static void main(String[] args) {
       Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println('z'-'A');
        System.out.println(solution.minWindow("cabwefgewcwaefgcf","cae"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        int len = s.length();

        int[] dir = new int[58];
        for (Character c : t.toCharArray()) {
            dir[c-'A']++;
        }

        int l = 0, r = 0;
        int min = len+1;
        int minStart = 0;
        Map<Integer, Integer> window = new HashMap<>();
        char[] sChars = s.toCharArray();
        while (r < len) {
            int inputKey = sChars[r] - 'A';
            window.put(inputKey, window.getOrDefault(inputKey, 0)+1);
            while (check(window, dir)) {
                int cur = r-l+1;
                if (cur < min) {
                    min = cur;
                    minStart = l;
                }
                int dropKey = sChars[l]-'A';
                window.put(dropKey, window.get(dropKey)-1);
                l++;
            }
            r++;
        }
        return min == len+1 ? "" : s.substring(minStart, minStart+min);
    }

    public boolean check(Map<Integer, Integer> window, int[] dir) {
        for (int i = 0; i < 58; i++) {
            if (dir[i] > 0 && (!window.containsKey(i) || dir[i] > window.get(i))) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
