//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。 
//
// 返回仅包含 1 的最长（连续）子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释： 
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 0 <= K <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 双指针 Sliding Window 
// 👍 151 👎 0


package com.martin.leetcode.editor.cn;


public class MaxConsecutiveOnesIii{
    public static void main(String[] args) {
       Solution solution = new MaxConsecutiveOnesIii().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int longestOnes(int[] A, int K) {
        int len = A.length;
        int longest = 0;
        int l = 0, r = 0;
        int count1 = 0;
        while (r < len) {
            if (A[r] == 1) {
                count1++;
            }
            while (count1+K < r-l+1) {
                if (A[l] == 1) {
                    count1--;
                }
                l++;
            }
            longest = Math.max(longest, r-l+1);
            r++;
        }
        return longest;
    }*/

    public int longestOnes(int[] A, int K) {
        int len = A.length;
        int l = 0, r = len;
        int[] sum = new int[len+1];
        for (int i = 0; i < len; i++) {
            sum[i+1] = sum[i] + A[i];
        }
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid, sum, K)) {
                l = mid;
            } else {
                r = mid-1;
            }
        }
        return l;
    }

    private boolean check(int len, int[] sum, int K) {
        for (int i = len; i < sum.length; i++) {
            if (sum[i] - sum[i-len] + K >= len) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
