//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 416 👎 0

  
package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString{

    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 			执行耗时:16 ms,击败了50.50% 的Java用户
         * 			内存消耗:39.4 MB,击败了84.56% 的Java用户
         */
/*    public List<Integer> findAnagrams(String s, String p) {
        int[] dic = new int[26];
        int[] window = new int[26];
        List<Integer> res = new ArrayList<>();

        if (s.length() == 0 || s.length() < p.length()) return res;

        for (int i = 0; i < p.length(); i++) {
            dic[p.charAt(i)-'a']++;
            window[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length()-p.length()+1; i++) {
            if (Arrays.equals(dic, window)) res.add(i);

            if (i+p.length() < s.length()) {
                window[s.charAt(i)-'a']--;
                window[s.charAt(i+p.length())-'a']++;
            }
        }
        return res;
    }*/

        /**
         * 			执行耗时:10 ms,击败了64.88% 的Java用户
         * 			内存消耗:39.6 MB,击败了73.83% 的Java用户
         *
         * 			执行耗时:7 ms,击败了82.67% 的Java用户
         * 			内存消耗:39.2 MB,击败了94.50% 的Java用户
         *
         * 			执行耗时:5 ms,击败了93.08% 的Java用户
         * 			内存消耗:39.3 MB,击败了90.44% 的Java用户
         */
    public List<Integer> findAnagrams(String s, String p) {
        int[] dic = new int[26];
        int[] window = new int[26];
        List<Integer> res = new ArrayList<>();
        int sL = s.length();
        int pL = p.length();

        if (sL == 0 || sL < pL) return res;

        for (int i = 0; i < pL; i++) {
            dic[p.charAt(i)-'a']++;
        }

        int left = 0;
        int right = 0;
        while (right < sL) {
            int curR = s.charAt(right)-'a';
            window[curR]++;
            while (window[curR] > dic[curR]) {
                window[s.charAt(left)-'a']--;
                left++;
            }
            if (right-left+1 == pL) {
                res.add(left);
            }
            right++;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}