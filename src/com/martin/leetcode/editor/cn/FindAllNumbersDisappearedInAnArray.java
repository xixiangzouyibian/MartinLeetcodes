//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 563 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray{
    public static void main(String[] args) {
       Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
       int a = 2, b = 7;
       a = a ^ b;
       b = a ^ b;
       a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        boolean[] count = new boolean[len+1];
        for (int num : nums) {
            count[num] = true;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            if (!count[i]) {
                res.add(i);
            }
        }
        return res;
    }*/


/*    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != nums[nums[i]-1]) { // swap handling
                swap(nums, i, nums[i]-1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i+1 != nums[i]) {
                res.add(i+1);
            }
        }
        return res;
    }

    public void swap(int[] nums, int x, int y) {
        nums[x] = nums[x] ^ nums[y];
        nums[y] = nums[x] ^ nums[y];
        nums[x] = nums[x] ^ nums[y];
    }*/

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num-1] > 0) {
                nums[num-1] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
