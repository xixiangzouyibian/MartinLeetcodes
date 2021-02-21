//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1136 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
       Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0) return new ArrayList<>();

        String[] map = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";

        List<String> res = new ArrayList<>();
        dfs(digits, 0, len, map, new StringBuilder(), res);
        return res;
    }

    private void dfs(String digits, int level, int len, String[] map, StringBuilder track, List<String> res) {
        if (level == len) {
            res.add(new StringBuilder(track).toString());
            return;
        }
        int index = digits.charAt(level) - '0';
        char[] chars = map[index].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            track.append(chars[i]);
            dfs(digits, level+1, len, map, track, res);
            track.deleteCharAt(track.length()-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
