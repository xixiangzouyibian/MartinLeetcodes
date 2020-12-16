//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 282 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class WordPattern{
    public static void main(String[] args) {
       Solution solution = new WordPattern().new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

/*    public boolean wordPattern(String pattern, String s) {
        if (s == null || s.length() == 0) return false;
        String[] words = s.split(" ");
        if (pattern.length() != words.length || pattern.length() == 0) return false;

        int len = pattern.length();
        Map<Character, String> pattern2s = new HashMap<>();
        Map<String, Character> s2pattern = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!pattern2s.containsKey(pattern.charAt(i))) {
                pattern2s.put(pattern.charAt(i), words[i]);
            } else {
                if (!pattern2s.get(pattern.charAt(i)).equals(words[i]))
                    return false;
            }

            if (!s2pattern.containsKey(words[i])) {
                s2pattern.put(words[i], pattern.charAt(i));
            } else {
                if (!s2pattern.get(words[i]).equals(pattern.charAt(i)))
                    return false;
            }
        }
        return true;
    }*/

    public boolean wordPattern(String pattern, String s) {
        if (s == null || s.length() == 0) return false;
        String[] words = s.split(" ");
        if (pattern.length() != words.length || pattern.length() == 0) return false;

        int len = pattern.length();
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer a = map.put(pattern.charAt(i), i);
            Integer b = map.put(words[i], i);
            if ((a != null && !a.equals(b)) || a == null && b != null)
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
