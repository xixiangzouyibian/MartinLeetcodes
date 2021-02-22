//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法 
// 👍 245 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation{
    public static void main(String[] args) {
       Solution solution = new LetterCasePermutation().new Solution();
        System.out.println();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        int len = S.length();
        if (len == 0) return res;

        dfs(S, 0, len, new StringBuilder(), res);

        return res;
    }

    private void dfs(String s, int start, int len, StringBuilder track, List<String> res) {
        if (start == len) {
            res.add(new StringBuilder(track).toString());
            return;
        }

        char c = s.charAt(start);
        if (!isLetter(c)) {
            track.append(c);
            dfs(s, start+1, len, track, res);
            track.deleteCharAt(track.length()-1);
            return;
        }

        track.append(c);
        dfs(s, start+1, len, track, res);
        track.deleteCharAt(track.length()-1);

        track.append(c ^= 1 << 5);
        dfs(s, start+1, len, track, res);
        track.deleteCharAt(track.length()-1);
    }

    private boolean isLetter(char c) {
        int diff = c - 'A';
        return diff >=0 && diff <= 57;
    }*/

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        int len = S.length();
        if (len == 0) return res;

        dfs(S.toCharArray(), 0, len, res);

        return res;
    }

    private void dfs(char[] chars, int start, int len, List<String> res) {
        if (start == len) {
            res.add(String.valueOf(chars));
            return;
        }
        dfs(chars, start+1, len, res);
        if (Character.isLetter(chars[start])) {
            chars[start] ^= 1 << 5;
            dfs(chars, start+1, len, res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
