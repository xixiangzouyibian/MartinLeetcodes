//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 216 👎 0


package com.martin.leetcode.editor.cn;


public class VolumeOfHistogramLcci{
    public static void main(String[] args) {
       Solution solution = new VolumeOfHistogramLcci().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int cur = stack.pop();
                if (!stack.isEmpty()) {
                    int l = stack.peek();
                    res += (i - l - 1) * (Math.min(height[l], height[i]) - height[cur]);
                }
            }
            stack.push(i);
        }
        return res;
    }*/

    public int trap(int[] height) {
        int len = height.length;
        if (len == 0) return 0;

        int res = 0;
        int[] left = new int[len];
        left[0] = height[0];
        int[] right = new int[len];
        right[len-1] = height[len-1];
        for (int i = 1; i < len; i++) left[i] = Math.max(left[i-1], height[i]);
        for (int i = len -2; i >= 0; i--) right[i] = Math.max(right[i+1], height[i]);

        for (int i = 0; i < len; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
