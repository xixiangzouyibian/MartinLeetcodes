//一群朋友在度假期间会相互借钱。比如说，小爱同学支付了小新同学的午餐共计 10 美元。如果小明同学支付了小爱同学的出租车钱共计 5 美元。我们可以用一个三元组
// (x, y, z) 表示一次交易，表示 x 借给 y 共计 z 美元。用 0, 1, 2 表示小爱同学、小新同学和小明同学（0, 1, 2 为人的标号），上述
//交易可以表示为 [[0, 1, 10], [2, 0, 5]]。 
//
// 给定一群人之间的交易信息列表，计算能够还清所有债务的最小次数。 
//
// 注意： 
//
// 
// 一次交易会以三元组 (x, y, z) 表示，并有 x ≠ y 且 z > 0。 
// 人的标号可能不是按顺序的，例如标号可能为 0, 1, 2 也可能为 0, 2, 6。 
// 
//
// 
//
// 示例 1： 
//
// 输入：
//[[0,1,10], [2,0,5]]
//
//输出：
//2
//
//解释：
//人 #0 给人 #1 共计 10 美元。
//人 #2 给人 #0 共计 5 美元。
//
//需要两次交易。一种方式是人 #1 分别给人 #0 和人 #2 各 5 美元。
// 
//
// 
//
// 示例 2： 
//
// 输入：
//[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]
//
//输出：
//1
//
//解释：
//人 #0 给人 #1 共计 10 美元。Person #0 gave person #1 $10.
//人 #1 给人 #0 共计 1 美元。Person #1 gave person #0 $1.
//人 #1 给人 #2 共计 5 美元。Person #1 gave person #2 $5.
//人 #2 给人 #0 共计 5 美元。Person #2 gave person #0 $5.
//
//因此，人 #1 需要给人 #0 共计 4 美元，所有的债务即可还清。
// 
//
// 
// 👍 63 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalancing{
    public static void main(String[] args) {
       Solution solution = new OptimalAccountBalancing().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> statis = new HashMap<>();
        for (int[] trans : transactions) {
            statis.put(trans[0], statis.getOrDefault(trans[0], 0) - trans[2]);
            statis.put(trans[1], statis.getOrDefault(trans[1], 0) + trans[2]);
        }
        int[] debts = statis.values().stream()
                .filter(v -> v != 0)
                .mapToInt(v -> v).toArray();
        Arrays.sort(debts); // benefits for shorten dfs counts
        return dfs(0, debts.length, debts);
    }

    private int dfs(int start, int len, int[] debts) {
        while (start < len && debts[start] == 0) start++;
        if (start == len) return 0;

        int min = Integer.MAX_VALUE;
        for (int i = start+1; i < len; i++) {
            if (debts[start] * debts[i] < 0) {
                debts[i] += debts[start];
                min = Math.min(min, 1+dfs(start+1, len, debts));
                debts[i] -= debts[start];
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
