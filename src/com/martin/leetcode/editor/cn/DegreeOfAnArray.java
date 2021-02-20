//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 
// 👍 261 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray{
    public static void main(String[] args) {
       Solution solution = new DegreeOfAnArray().new Solution();
        System.out.println(solution.findShortestSubArray(new int[] {3,2,3,3,2,1,1,2,3,1,1,3,2,1,2,2,2,2,1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> infoMap = new HashMap<>(); //[0] start, [1] end, [2] count
        int maxCount = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] info;
            if (!infoMap.containsKey(nums[i])) {
                info = new int[] {i,i,1};
                infoMap.put(nums[i], info);
            } else {
                info = infoMap.get(nums[i]);
                info[1] = i;
                info[2]++;
                maxCount = Math.max(maxCount, info[2]);
            }
        }
        int shortest = 50000;
        for (int k : infoMap.keySet()) {
            int[] info = infoMap.get(k);
            if (info[2] == maxCount) {
                shortest = Math.min(shortest, info[1] - info[0] +1);
            }
        }
        return shortest == 50000 ? 1 : shortest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
