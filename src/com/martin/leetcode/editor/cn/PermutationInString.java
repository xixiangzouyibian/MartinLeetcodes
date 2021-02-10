//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 293 👎 0


package com.martin.leetcode.editor.cn;


public class PermutationInString{
    public static void main(String[] args) {
       Solution solution = new PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("kitten","sitting"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        int[] s1Freq = new int[26];
        char[] s1Chars = s1.toCharArray();
        int s1Count = 0;
        for (int i = 0; i < s1Len; i++) {
            if (s1Freq[s1Chars[i]-'a'] == 0) {
                s1Count++;
            }
            s1Freq[s1Chars[i]-'a']++;
        }

        char[] s2Chars = s2.toCharArray();
        int[] s2Freq = new int[26];
        int l = 0, r = 0;
        int count = 0;
        while (r < s2Len) {
            if (s1Freq[s2Chars[r]-'a'] > 0) {
                s2Freq[s2Chars[r] - 'a']++;
                if (s2Freq[s2Chars[r] - 'a'] == s1Freq[s2Chars[r] - 'a']) {
                    count++;
                }
            }
            r++;
            while (count == s1Count) {
                if (r-l == s1Len) {
                    return true;
                }
                if (s1Freq[s2Chars[l]-'a'] > 0) {
                    s2Freq[s2Chars[l]-'a']--;
                    if (s2Freq[s2Chars[l]-'a'] < s1Freq[s2Chars[l]-'a']) {
                        count--;
                    }
                }
                l++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
