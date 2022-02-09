//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 数学 二分查找 👍 10 👎 0

  
package com.martin.leetcode.editor.cn;

public class JJ0w9p{
    public static void main(String[] args) {
       Solution solution = new JJ0w9p().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (check(mid, x)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return (int) r;
    }

    private boolean check(long x, long target) {
        return x * x > target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}