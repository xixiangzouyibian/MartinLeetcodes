//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 104 
// 0 <= t <= 231 - 1 
// 
// Related Topics 排序 Ordered Map 
// 👍 411 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIii{
    public static void main(String[] args) {
       Solution solution = new ContainsDuplicateIii().new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[] {2147483647,-1,2147483647}, 1, 2147483647));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

/*    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long n = nums[i] * 1L;
            Long l = set.floor(n);
            Long r = set.ceiling(n);
            if (l != null && Math.abs(l-n) <= t) return true;
            if (r != null && Math.abs(r-n) <= t) return true;

            set.add(n);
            if (i >= k) set.remove(nums[i-k] * 1L);
        }

        return false;
    }*/

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            long n = nums[i] * 1L;
            long idx = getID(n, t);
            if (map.containsKey(idx)) return true;

            long l = idx - 1;
            if (map.containsKey(l) && n - map.get(l) <= t) return true;

            long r = idx + 1;
            if (map.containsKey(r) && map.get(r) - n <= t) return true;

            map.put(idx, n);

            if (i >= k) map.remove(getID(nums[i-k] * 1L, t));
        }

        return false;
    }

    private long getID(long n, int t) {
        if (n >= 0) {
            return n / (t+1);
        }
        return (n+1) / (t+1) - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
