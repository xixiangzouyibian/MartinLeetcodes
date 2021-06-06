//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
// Related Topics 动态规划 
// 👍 435 👎 0


package com.martin.leetcode.editor.cn;


public class OnesAndZeroes{
    public static void main(String[] args) {
       Solution solution = new OnesAndZeroes().new Solution();
//        System.out.println(solution.findMaxForm(new String[] {"10","0001","111001","1","0"}, 5, 3));
        System.out.println(solution.findMaxForm(new String[] {"111","1000","1000","1000"}, 9, 3));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int [len+1][m+1][n+1];

        for (int i = 1; i <= len; i++) {
            int[] count = count01(strs[i-1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    if (j >= count[0] && k >= count[1])
                        dp[i][j][k] = Math.max(dp[i][j][k], 1 + dp[i-1][j-count[0]][k-count[1]]);
                }
            }
        }
        return dp[len][m][n];
    }

    private int[] count01(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            res[c-'0']++;
        }
        return res;
    }

/*    int[][][] mem;

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        mem = new int[len][m+1][n+1];
        for (int[][] ints : mem) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int count0 = 0;
            char[] cc = strs[i].toCharArray();
            for (char c : cc) {
                if (c == '0') count0++;
            }
            map.put(i, new int[] {count0, strs[i].length() - count0});
        }

        return dfs(map, len-1, m, n);
    }

    private int dfs(Map<Integer, int[]> map, int start, int m, int n) {
        if (start < 0) return 0;

        if (mem[start][m][n] != -1) return mem[start][m][n];

        int[] info = map.get(start);
        if (m >= info[0] && n >= info[1]) {
            mem[start][m][n] = Math.max(dfs(map, start-1, m, n),
                    1 + dfs(map, start-1, m - info[0], n - info[1]));
        } else {
            mem[start][m][n] = dfs(map, start-1, m, n);
        }

        return mem[start][m][n];
    }*/

/*    int res = 0;
    private void dfs(Map<Integer, int[]> map, int[] record, int start, int m, int n) {
        if (start == map.size()) {
            res = Math.max(res, record[2]);
            return;
        }

        dfs(map, record, start+1, m, n);
        int[] info = map.get(start);
        if (record[0] + info[0] <= m && record[1] + info[1] <= n) {
            record[0] += info[0];
            record[1] += info[1];
            record[2]++;
            dfs(map, record, start+1, m, n);
            record[0] -= info[0];
            record[1] -= info[1];
            record[2]--;
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}
