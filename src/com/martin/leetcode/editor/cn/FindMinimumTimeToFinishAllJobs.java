//给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。 
//
// 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你
//设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。 
//
// 返回分配方案中尽可能 最小 的 最大工作时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：jobs = [3,2,3], k = 3
//输出：3
//解释：给每位工人分配一项工作，最大工作时间是 3 。
// 
//
// 示例 2： 
//
// 
//输入：jobs = [1,2,4,7,8], k = 2
//输出：11
//解释：按下述方式分配工作：
//1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
//2 号工人：4、7（工作时间 = 4 + 7 = 11）
//最大工作时间是 11 。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= jobs.length <= 12 
// 1 <= jobs[i] <= 107 
// 
// Related Topics 递归 回溯算法 
// 👍 163 👎 0


package com.martin.leetcode.editor.cn;


public class FindMinimumTimeToFinishAllJobs{
    public static void main(String[] args) {
       Solution solution = new FindMinimumTimeToFinishAllJobs().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int minimumTimeRequired(int[] jobs, int k) {
        dfs(jobs, 0, jobs.length, new int[k], k, 0);
        return res;
    }

    int res = Integer.MAX_VALUE;
    private void dfs(int[] jobs, int start, int len, int[] workers, int k, int max) {
        if (start == len) {
            res = Math.min(res, max);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < k; j++) {
            if (!set.add(workers[j])) continue;
            if (workers[j] + jobs[start] >= res) continue;

            workers[j] += jobs[start];
            dfs(jobs, start+1, len, workers, k, Math.max(max, workers[j]));
            workers[j] -= jobs[start];
        }
    }*/

    public int minimumTimeRequired(int[] jobs, int k) {
        dfs(jobs, 0, jobs.length, 0, new int[k], k, 0);
        return res;
    }

    int res = Integer.MAX_VALUE;
    private void dfs(int[] jobs, int start, int len, int used, int[] workers, int k, int max) {
        if (max >= res) return;

        if (start == len) {
            res = Math.min(res, max);
            return;
        }

        if (used < k) {
            workers[used] = jobs[start];
            dfs(jobs, start+1, len, used+1, workers, k, Math.max(max, workers[used]));
            workers[used] = 0;
        }

        for (int j = 0; j < used; j++) {
            workers[j] += jobs[start];
            dfs(jobs, start+1, len, used, workers, k, Math.max(max, workers[j]));
            workers[j] -= jobs[start];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
