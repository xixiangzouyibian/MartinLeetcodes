//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 282 👎 0

  
package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString{

    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                map.put(cur, i);
            } else {
                map.put(cur, s.length());
            }
        }

        int min = s.length();
        for (char c : map.keySet()) {
            min = Math.min(min, map.get(c));
        }
        return min == s.length() ? -1 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}