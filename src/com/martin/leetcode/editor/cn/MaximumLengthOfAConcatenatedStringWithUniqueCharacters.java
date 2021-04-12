//给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。 
//
// 请返回所有可行解 s 中最长长度。 
//
// 
//
// 示例 1： 
//
// 输入：arr = ["un","iq","ue"]
//输出：4
//解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
// 
//
// 示例 2： 
//
// 输入：arr = ["cha","r","act","ers"]
//输出：6
//解释：可能的解答有 "chaers" 和 "acters"。
// 
//
// 示例 3： 
//
// 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
//输出：26
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 16 
// 1 <= arr[i].length <= 26 
// arr[i] 中只含有小写英文字母 
// 
// Related Topics 位运算 回溯算法 
// 👍 86 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters{
    public static void main(String[] args) {
       Solution solution = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().new Solution();
        System.out.println(solution.maxLength(Arrays.asList("jnfbyktlrqumowxd","mvhgcpxnjzrdei")));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int maxLength(List<String> arr) {
        dfs(arr, 0, arr.size(), "");
        return res;
    }

    int res = 0;
    private void dfs(List<String> arr, int start, int size, String s) {
        if (start == size) {
            res = Math.max(res, s.length());
            return;
        }

        String cur = arr.get(start);
        if (check(s, cur)) {
            dfs(arr, start+1, size, s+cur);
        }
        dfs(arr, start+1, size, s);
    }

    private boolean check(String s, String sa) {
        int[] freq = new int[26];

        char[] cc = (s + sa).toCharArray();
        for (char c : cc) {
            freq[c - 'a']++;
            if (freq[c-'a'] > 1) return false;
        }

        return true;
    }
 */

    public int maxLength(List<String> arr) {
        return dfs(arr, 0, arr.size(), 0);
    }

    private int dfs(List<String> arr, int start, int size, int record) {
        if (start == size) {
            return 0;
        }

        int res = 0;
        for (int i = start; i < size; i++) {
            String cur = arr.get(i);
            int nr = check(record, cur);
            if (nr == -1) continue;
            res = Math.max(res, dfs(arr, i+1, size, nr) + cur.length());
        }
        return res;
    }

    private int check(int r, String sa) {
        for (char c : sa.toCharArray()) {
            if ((r & (1 << c-'a')) != 0) return -1;
            r |= 1 << c-'a';
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
