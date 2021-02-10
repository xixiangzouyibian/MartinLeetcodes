//给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。 
//
// （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。） 
//
// 返回 A 中好子数组的数目。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,2,1,2,3], K = 2
//输出：7
//解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
// 
//
// 示例 2： 
//
// 输入：A = [1,2,1,3,4], K = 3
//输出：3
//解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 1 <= A[i] <= A.length 
// 1 <= K <= A.length 
// 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 247 👎 0


package com.martin.leetcode.editor.cn;


public class SubarraysWithKDifferentIntegers{
    public static void main(String[] args) {
       Solution solution = new SubarraysWithKDifferentIntegers().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostSubarraysWithDistinct(A, K) - atMostSubarraysWithDistinct(A, K-1);
    }

    private int atMostSubarraysWithDistinct(int[] A, int K) {
        int len = A.length;
        int l = 0, r = 0;
        int ans = 0;
        int count = 0;
        int[] freq = new int[len+1];
        while (r < len) {
            if (freq[A[r]] == 0) {
                count++;
            }
            freq[A[r]]++;
            while (count > K) {
                freq[A[l]]--;
                if (freq[A[l]] == 0) {
                    count--;
                }
                l++;
            }
            ans += r -l + 1;
            r++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
