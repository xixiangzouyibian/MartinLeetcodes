//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 239 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangleIi{
    public static void main(String[] args) {
       Solution solution = new PascalsTriangleIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Collections.singletonList(1);

        Integer[] nums = new Integer[rowIndex+1];
        for (int i = 1; i <= rowIndex; i++) {
            nums[0] = 1;
            nums[i] = 1;
            for (int j = i-1; j >= 1; j--) {
                nums[j] = nums[j-1]+nums[j];
            }
        }
        return Arrays.asList(nums);
    }*/

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Collections.singletonList(1);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            list.add((int)((long)list.get(i-1) * (rowIndex-i+1) / i));
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
