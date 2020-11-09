//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 255 👎 0

  
package com.martin.leetcode.editor.cn;


public class ReverseWordsInAStringIii{

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(5);
        sb.insert(3, 'Z');
        System.out.println(sb.toString());
        Solution solution = new ReverseWordsInAStringIii().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public String reverseWords(String s) {
        Deque<Character> words = new ArrayDeque<>();
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                while (!words.isEmpty()) reversed.append(words.pop());
                reversed.append(' ');
            } else {
                words.offerFirst(s.charAt(i));
            }
        }
        while (!words.isEmpty()) reversed.append(words.pop());
        return reversed.toString();
    }*/

/*    public String reverseWords(String s) {
        Deque<String> reversed = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        for (int i=s.length()-1; i >=0; i--) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                reversed.offerFirst(word.toString());
                word.setLength(0);
            }
        }
        reversed.offerFirst(word.toString());
        return String.join(" ", reversed);
    }*/

    public String reverseWords(String s) {
        int start = 0;
        char[] chars = (s+" ").toCharArray();
        for (int i=0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int end = i-1;
                while (start < end) {
                    char tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;
                    start++;
                    end--;
                }
                start = i+1;
            }
        }
        return new String(chars, 0, chars.length-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}