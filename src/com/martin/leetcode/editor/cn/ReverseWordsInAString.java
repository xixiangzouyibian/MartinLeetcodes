//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 说明： 
//
// 
// 无空格字符构成一个 单词 。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 示例 1： 
//
// 输入："the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 输入："  hello world!  "
//输出："world! hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入："a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 示例 4： 
//
// 输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
// 
//
// 示例 5： 
//
// 输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 请尝试使用 O(1) 额外空间复杂度的原地解法。 
// 
// Related Topics 字符串 
// 👍 240 👎 0

  
package com.martin.leetcode.editor.cn;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString{

    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public String reverseWords(String s) {
        Deque<Character> sentence = new ArrayDeque<>(s.length());
        Deque<Character> word = new ArrayDeque<>(s.length());
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sentence.push(s.charAt(i));
        }

        while (!sentence.isEmpty()) {
            if (sentence.peek() != ' ') {
                word.push(sentence.pop());
            } else {
                if (!word.isEmpty()) {
                    if (reversed.length() > 0) reversed.append(' ');
                    while (!word.isEmpty()) reversed.append(word.pop());
                } else {
                    sentence.pop();
                }
            }
        }

        if (!word.isEmpty()) {
            if (reversed.length() > 0) reversed.append(' ');
            while (!word.isEmpty()) reversed.append(word.pop());
        }
        return reversed.toString();
    }*/

    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    // 1 deque
    // double pointers
    // recursive
}
//leetcode submit region end(Prohibit modification and deletion)

}