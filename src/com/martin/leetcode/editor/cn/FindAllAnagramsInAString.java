//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 416 👎 0

  
package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString{

    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("abab", "ab"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> dic = new HashMap<>();
        for (int i =0; i < p.length(); i++) {
            if (!dic.containsKey(p.charAt(i))) {
                dic.put(p.charAt(i), 1);
            } else {
                dic.put(p.charAt(i), dic.get(p.charAt(i))+1);
            }
        }

        int section = p.length();
        int start = 0;
        List<Integer> res = new ArrayList<>();
        boolean isAnagrams = true;
        while (start+section <= s.length()) {
            Map<Character, Integer> dicC = new HashMap<>(dic);
            for (int j = start; j < start+section; j++) {
                isAnagrams = (dicC.containsKey(s.charAt(j)) && dicC.get(s.charAt(j)) > 0) && isAnagrams;
                if (!isAnagrams) break;
                dicC.put(s.charAt(j), dicC.get(s.charAt(j))-1);
            }
            if (isAnagrams) {
                res.add(start);
                int end = start+section-1;
                while (++end < s.length() && s.charAt(end) == s.charAt(end-section)) res.add(++start);
            }
            isAnagrams = true;
            ++start;
        }
        return res;
    }*/

/*        public List<Integer> findAnagrams(String s, String p) {

            int pLength = p.length();
            int sLength = s.length();
            int[] counts = new int[26];
            for(int i = 0; i < pLength; i++){
                counts[p.charAt(i) - 'a']++;
            }

            ArrayList<Integer> res = new ArrayList<>();

            for(int i = 0; i <= sLength - pLength; i++){
                int[] tempCounts = Arrays.copyOf(counts, 26);
                int j = i;
                for(; j < sLength && j < pLength + i; j++){
                    if(--tempCounts[s.charAt(j) - 'a'] < 0){
                        break;
                    }
                }
                if(j >= pLength + i){
                    res.add(i);
                }
            }
            return res;
        }*/

/*        public List<Integer> findAnagrams(String s, String p) {

            // 先对目标串p每个字符进行字符计数，统计出每个字符的出现次数
            int pLength = p.length();
            int sLength = s.length();

            int[] counts = new int[26];
            for(int i = 0; i < pLength; i++){
                counts[p.charAt(i) - 'a']++;
            }

            ArrayList<Integer> res = new ArrayList<>();  // 存储结果的结果集

            int[] tempCounts = new int[26]; // 记录窗口内每种字符的出现次数
            int left = 0, right = 0;
            while(right < sLength){
                int curR = s.charAt(right) - 'a';
                tempCounts[curR]++;        // curR字符的出现次数加一
                right++;    // 新增一个字符后，窗口右指针右移一位
                while(tempCounts[curR] > counts[curR]){ // 不断缩小窗口大小，直到把超标字符移出去一个，使得不超标
                    tempCounts[s.charAt(left) - 'a']--;
                    left++;     // 移走一个字符后窗口左指针右移一位
                }
                if(right - left == pLength){
                    res.add(left);
                }
            }
            return res;
        }*/

        public List<Integer> findAnagrams(String s, String p) {//使用2个数组记录每个字符出现次数，通过遍历数组，判断是否一致
            if(s.length()==0||s.length()<p.length())return new ArrayList<>();
            int [] pMap = new int [26];
            int [] windows = new int [26];
            int winlen = p.length();
            for(int i=0;i<winlen;i++){
                pMap[p.charAt(i)-'a']++;
                windows[s.charAt(i)-'a']++;
            }
            List<Integer> res = new ArrayList<>();
            if(isSame(pMap,windows))    res.add(0);
            for(int i=0;i<s.length()-winlen;i++){
                windows[s.charAt(i+winlen)-'a']++;
                windows[s.charAt(i)-'a']--;
                if(isSame(pMap,windows))    res.add(i+1);
            }
            return res;
        }
        private boolean isSame(int []a,int[] b){
            for(int i=0;i<26;i++){
                if(a[i]!=b[i])return false;
            }
            return true;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}