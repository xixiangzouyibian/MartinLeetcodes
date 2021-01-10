//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4801 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
       Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int r = 0;
        int max = 0;
        Deque<Character> window = new ArrayDeque<>();
        while (r < len) {
            char c = s.charAt(r);
            if (window.contains(c)) {
                while (!window.isEmpty() && window.poll() != c);
            }
            window.offer(c);
            max = Math.max(max, window.size());
            r++;
        }
        return max;
    }*/

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int l = 0;
        int r = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < len) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                l = Math.max(l, map.get(c)+1);
            }
            map.put(c, r);
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
