//给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。 
//
// 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i, j < n 。 
//
// 你能在O(n)的时间解决这个问题吗？ 
//
// 示例: 
//
// 
//输入: [3, 10, 5, 25, 2, 8]
//
//输出: 28
//
//解释: 最大的结果是 5 ^ 25 = 28.
// 
// Related Topics 位运算 字典树 
// 👍 209 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashSet;
import java.util.Set;

public class MaximumXorOfTwoNumbersInAnArray{
    public static void main(String[] args) {
       Solution solution = new MaximumXorOfTwoNumbersInAnArray().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    class TrieNode {
        TrieNode[] nodes = new TrieNode[2];
    }

    TrieNode root = new TrieNode();
    int MAX_BITS = 0;

    public void insert(int num) {
        TrieNode cur = root;
        for (int i = MAX_BITS; i >= 0 ; i--) {
            int bit = (num >> i) & 1;
            TrieNode next = cur.nodes[bit];
            if (next == null) {
                cur.nodes[bit] = new TrieNode();
            }
            cur = cur.nodes[bit];
        }
    }

    public int searchMaxXor(int num) {
        TrieNode cur = root;
        int result = 0;
        for (int i = MAX_BITS; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int rBit = bit ^ 1;
            TrieNode next = cur.nodes[rBit];
            if (next != null) {
                result += 1 << i;
                cur = next;
            } else {
                cur = cur.nodes[bit];
            }
        }
        return result;
    }

    public int findMaximumXOR(int[] nums) {
        int len = nums.length;

        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
           maxNum = Math.max(maxNum, nums[i]);
        }
        MAX_BITS = Integer.toBinaryString(maxNum).length();

        for (int i = 0; i < len; i++) {
            insert(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, searchMaxXor(nums[i]));
        }
        return max;
    }*/

    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 30; i >=0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(mask & num);
            }
            int expect = res | (1 << i);
            for (int prefix : set) {
                if (set.contains(prefix ^ expect)) {
                    res = expect;
                    break;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
