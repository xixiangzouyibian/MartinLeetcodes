//当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组： 
//
// 
// 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]； 
// 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。 
// 
//
// 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。 
//
// 返回 A 的最大湍流子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：[9,4,2,10,7,8,8,1,9]
//输出：5
//解释：(A[1] > A[2] < A[3] > A[4] < A[5])
// 
//
// 示例 2： 
//
// 输入：[4,8,12,16]
//输出：2
// 
//
// 示例 3： 
//
// 输入：[100]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 40000 
// 0 <= A[i] <= 10^9 
// 
// Related Topics 数组 动态规划 Sliding Window 
// 👍 126 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;

public class LongestTurbulentSubarray{
    public static void main(String[] args) {
       Solution solution = new LongestTurbulentSubarray().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len == 1) return 1;
        // '>' is 001, '<' is 010, '=' is 100
        int[] format = new int[len-1];
        for (int i = 1; i < len; i++) {
            if (arr[i-1] < arr[i]) {
                format[i-1] = 2;
            } else if (arr[i-1] > arr[i]) {
                format[i-1] = 1;
            } else {
                format[i-1] = 4;
            }
        }

        int max = format[0] == 4 ? 0 : 1;
        int l = 0, r = 0;
        while (r < format.length-1) {
            r++;
            if ((format[r-1] ^ format[r]) != 3) {
                l = r;
            }
            if (format[r] != 4) { // 这里需要注意如果是=的情况，不做max的统计
                max = Math.max(max, r-l+1);
            }
        }
        return max+1;
    }*/

/*    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len == 1) return 1;
        // '>' is 001, '<' is 010, '=' is 100
        int[] format = new int[len-1];
        fill(arr[0], arr[1], format, 0);
        int max = format[0] == 4 ? 0 : 1;
        int l = 0, r = 0;
        while (r < format.length-1) {
            r++;
            fill(arr[r], arr[r+1], format, r);
            if ((format[r-1] ^ format[r]) != 3) {
                l = r;
            }
            if (format[r] != 4) {
                max = Math.max(max, r-l+1);
            }
        }
        return max+1;
    }

    private void fill(int x, int y, int[] format, int index) {
        if (x < y) {
            format[index] = 2;
        } else if (x > y) {
            format[index] = 1;
        } else {
            format[index] = 4;
        }
    }*/

    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len == 1) return 1;

        int[][] dp = new int[len][2]; // 0 is up, 1 is down
        for (int[] d : dp) {
            Arrays.fill(d, 1);
        }
        int max = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i-1]) continue;
            if (arr[i] > arr[i-1]) {
                dp[i][0] = dp[i-1][1] + 1;
            } else {
                dp[i][1] = dp[i-1][0] + 1;
            }
            max = Math.max(max, dp[i][0]);
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
