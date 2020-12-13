//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1861 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater{
  public static void main(String[] args) {
       Solution solution = new TrappingRainWater().new Solution();
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

/*    public int trap(int[] height) {
        int len = height.length;

        if (len == 0) return 0;

        int[] l_max = new int[len];
        int[] r_max = new int[len];

        l_max[0] = height[0];
        r_max[len-1] = height[len-1];
        for (int i = 1; i < len-1; i++) {
            l_max[i] = Math.max(l_max[i-1], height[i]);
        }

        for (int j = len-2; j >0; j--) {
            r_max[j] = Math.max(r_max[j+1], height[j]);
        }

        int ans = 0;
        for (int m = 1; m < len-1; m++) {
            ans += Math.min(l_max[m], r_max[m]) - height[m];
        }
        return ans;
    }*/

/*    public int trap(int[] height) {
        int len = height.length;
        if (len == 0) return 0;
        int left = 0;
        int right = len-1;
        int l_max = height[0];
        int r_max = height[len-1];

        int ans = 0;
        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            if (l_max > r_max) {
                ans += r_max - height[right];
                right--;
            } else {
                ans += l_max - height[left];
                left++;
            }
        }
        return ans;
    }*/

    public int trap(int[] height) {
      int len = height.length;
      if (len == 0) return 0;

      Deque<Integer> stack = new ArrayDeque<>();
      int ans = 0;
      for (int i = 0; i < len; i++) {
          while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
              int cur = stack.pop();
              if (stack.isEmpty()) break;
              int left = stack.peek();
              int right = i;
              ans += (right - left - 1) * (Math.min(height[left], height[right]) - height[cur]);
          }
          stack.push(i);
      }
      return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}