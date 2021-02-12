//给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。 
//
// 示例 1: 
//
// 输入: "eceba"
//输出: 3
//解释: t 是 "ece"，长度为3。
// 
//
// 示例 2: 
//
// 输入: "ccaabbb"
//输出: 5
//解释: t 是 "aabbb"，长度为5。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 93 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters{
    public static void main(String[] args) {
       Solution solution = new LongestSubstringWithAtMostTwoDistinctCharacters().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if (len < 3) return len;

        int l = 0, r = 0;
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        while (r < len) {
            map.put(chars[r], map.getOrDefault(chars[r], 0)+1);
            while (map.size() > 2) {
                int count = map.get(chars[l])-1;
                if (count == 0) {
                    map.remove(chars[l]);
                } else {
                    map.put(chars[l], count);
                }
                l++;
            }
            longest = Math.max(longest, r-l+1);
            r++;
        }
        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
