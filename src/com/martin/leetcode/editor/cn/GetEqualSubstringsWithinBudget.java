//给你两个长度相同的字符串，s 和 t。 
//
// 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的
//绝对值。 
//
// 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。 
//
// 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。 
//
// 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcd", t = "bcdf", cost = 3
//输出：3
//解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。 
//
// 示例 2： 
//
// 输入：s = "abcd", t = "cdef", cost = 3
//输出：1
//解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
// 
//
// 示例 3： 
//
// 输入：s = "abcd", t = "acde", cost = 0
//输出：1
//解释：你无法作出任何改动，所以最大长度为 1。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10^5 
// 0 <= maxCost <= 10^6 
// s 和 t 都只含小写英文字母。 
// 
// Related Topics 数组 Sliding Window 
// 👍 110 👎 0


package com.martin.leetcode.editor.cn;


public class GetEqualSubstringsWithinBudget{
    public static void main(String[] args) {
       Solution solution = new GetEqualSubstringsWithinBudget().new Solution();
        System.out.println(solution.equalSubstring("abcd","cdef",3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int l = 0, r = 0;
        int max = 0;
        int cost = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        while (r < len) {
            cost += Math.abs(sChars[r]-tChars[r]);
            while (cost > maxCost) {
                cost -= Math.abs(sChars[l]-tChars[l]);
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }*/

    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] diff = new int[len+1];
        for (int i = 0; i < len; i++) {
            diff[i+1] = diff[i]+Math.abs(s.charAt(i)-t.charAt(i));
        }
        int max = 0;
        for (int j = 1; j <= len; j++) {
            int k = check(diff, j, diff[j] - maxCost);
            max = Math.max(max, j - k);
        }
        return max;
    }

    public int check(int[] diff, int end, int target) { // target = diff[end] - maxCost and find start
        int l = 0;
        int h = end;
        while (l < h) {
            int mid = (l + h) >> 1;
            if (diff[mid] < target) {
                l = mid+1;
            } else {
                h = mid;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
