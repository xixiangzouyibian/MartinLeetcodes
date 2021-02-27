//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 369 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeastKRepeatingCharacters{
    public static void main(String[] args) {
       Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        System.out.println(solution.longestSubstring("aaabb", 3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        for (Character c : freq.keySet()) {
            if (freq.get(c) < k) {
                int res = 0;
                for (String ss : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(ss, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
