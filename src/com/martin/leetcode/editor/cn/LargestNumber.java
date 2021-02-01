//给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 456 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber{
    public static void main(String[] args) {
       Solution solution = new LargestNumber().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();

        for (String s :
                Arrays.stream(nums)
                        .boxed()
                        .map(Object::toString)
                        .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                        .collect(Collectors.toList())) {
            sb.append(s);
        }

        String result = sb.toString();

        return result.startsWith("0") ? "0" : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
