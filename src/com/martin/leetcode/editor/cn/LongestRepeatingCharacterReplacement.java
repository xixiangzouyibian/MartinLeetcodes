//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 344 👎 0


package com.martin.leetcode.editor.cn;


public class LongestRepeatingCharacterReplacement{
    public static void main(String[] args) {
       Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int characterReplacement(String s, int k) {
        int len = s.length();
        int left = 0, right = 0;

        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int count = 0;
        while (right < len) {
            int index = chars[right]-'A';
            map[index]++;
            count = Math.max(count, map[index]);
            if (right-left+1 > count+k) {
                map[chars[left]-'A']--;
                left++;
            }
            right++;
        }
        return len-left;
    }*/
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int left = 0, right = 0;

        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int res = 0;
        while (right < len) {
            int index = chars[right]-'A';
            map[index]++;
            while (right-left+1 > getCurMax(map)+k) {
                map[chars[left]-'A']--;
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }

    public int getCurMax(int[] map) {
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            max = Math.max(max, map[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
