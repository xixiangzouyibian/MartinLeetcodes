//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 350 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RussianDollEnvelopes{
    public static void main(String[] args) {
       Solution solution = new RussianDollEnvelopes().new Solution();
//        System.out.println(solution.maxEnvelopes(new int[][] {{5,4},{6,4},{6,7},{2,3}}));
        System.out.println(solution.maxEnvelopes(new int[][] {{1,3},{3,5},{6,7},{6,8},{8,4},{9,8}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len == 0) return 0;
        // sort envelopes
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        new LinkedList<>()
        int[] dp = new int[len];
        int res = 1;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, (int[] arr1, int[] arr2) -> {
            if (arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
        });
        return lengthOfLIS(envelopes);
    }

    public int lengthOfLIS(int[][] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int[] num : nums) {
            if (list.size() == 0 || list.get(list.size() - 1) < num[1])
                list.add(num[1]);
            else {
                int i = Collections.binarySearch(list, num[1]);

                list.set((i < 0) ? -i-1 : i, num[1]);
            }
        }
        return list.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
