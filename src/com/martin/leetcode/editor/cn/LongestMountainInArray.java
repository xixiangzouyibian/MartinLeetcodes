//我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”： 
//
// 
// B.length >= 3 
// 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
//[B.length - 1] 
// 
//
// （注意：B 可以是 A 的任意子数组，包括整个数组 A。） 
//
// 给出一个整数数组 A，返回最长 “山脉” 的长度。 
//
// 如果不含有 “山脉” 则返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,4,7,3,2,5]
//输出：5
//解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 输入：[2,2,2]
//输出：0
//解释：不含 “山脉”。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 双指针 
// 👍 169 👎 0


package com.martin.leetcode.editor.cn;


public class LongestMountainInArray{
    public static void main(String[] args) {
       Solution solution = new LongestMountainInArray().new Solution();
        System.out.println(solution.longestMountain(new int[] {2,1,4,7,3,2,5}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int longestMountain(int[] A) {
            int n = A.length;
            int[] left = new int[n]; // 左边有几个连续递减的数
            int[] right = new int[n]; // 右边有几个连续递减的数

            for (int i = 1; i < n; i++) {
                if (A[i] > A[i - 1]) {
                    left[i] = left[i - 1] + 1;
                }
            }

            for (int i = n - 2; i > -1; i--) {
                if (A[i] > A[i + 1]) {
                    right[i] = right[i + 1] + 1;
                }
            }

            int ans = 0;
            for (int i = 1; i < n - 1; i++) {
                if (left[i] > 0 && right[i] > 0) {
                    ans = Math.max(ans, left[i] + right[i] + 1);
                }
            }

            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
