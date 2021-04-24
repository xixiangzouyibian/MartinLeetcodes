//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 820 👎 0


package com.martin.leetcode.editor.cn;


public class ImplementStrstr{
    public static void main(String[] args) {
       Solution solution = new ImplementStrstr().new Solution();
        System.out.println(solution.strStr("aaaa", "aacaa"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int strStr(String haystack, String needle) {
        int hl = haystack.length(), nl = needle.length();
        char[] hc = haystack.toCharArray(), nc = needle.toCharArray();

        for (int i = 0; i <= hl - nl; i++) {
            int a = i, b = 0;
            while (b < nl && hc[a] == nc[b]) {
                a++;
                b++;
            }
            if (b == nl) return i;
        }
        return -1;
    }*/

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int m = haystack.length(), n = needle.length();
        haystack = " " + haystack;
        needle = " " + needle;
        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();

        //build next
        int[] next = new int[n+1];
        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && nc[i] != nc[j+1]) j = next[j]; // 将j指向上一次的前缀的位置
            if (nc[i] == nc[j+1]) j++;
            next[i] = j;
        }

        //kmp
        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && hc[i] != nc[j+1]) j = next[j];
            if (hc[i] == nc[j+1]) j++;
            if (j == n) return i - n;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
