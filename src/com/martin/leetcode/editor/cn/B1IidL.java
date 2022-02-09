//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 数组 二分查找 👍 66 👎 0

  
package com.martin.leetcode.editor.cn;

public class B1IidL{
    public static void main(String[] args) {
       Solution solution = new B1IidL().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (mid - 1 < 0 || mid + 1 >= arr.length) break;
            if (check(arr, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private boolean check(int[] arr, int i) {
        return arr[i] >= arr[i-1] && arr[i] <= arr[i+1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}