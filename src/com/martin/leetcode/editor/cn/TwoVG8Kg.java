//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 33 👎 0

  
package com.martin.leetcode.editor.cn;

import netscape.security.UserTarget;

public class TwoVG8Kg{
    public static void main(String[] args) {
       Solution solution = new TwoVG8Kg().new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] pre = new int[len+1];
        for (int i = 0; i < len; i++) {
            pre[i+1] = pre[i] + nums[i];
        }

        if (pre[len] < target) return 0;

        int l = 0, r = len;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(pre, mid, target)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean check(int[] pre, int step, int target) {
        for (int i = step; i < pre.length; i++) {
            if (pre[i] - pre[i-step] >= target) {
                return true;
            }
        }
        return false;
    }*/

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int from = 0, to = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (to < len) {
            sum += nums[to];
            while (sum >= target) {
                ans = Math.min(ans, to - from + 1);
                sum -= nums[from];
                from++;
            }
            to++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}