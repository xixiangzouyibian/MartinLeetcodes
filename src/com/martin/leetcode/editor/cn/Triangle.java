  //给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 609 👎 0

  
  package com.martin.leetcode.editor.cn;


  import lombok.extern.slf4j.Slf4j;

  import java.util.Arrays;
  import java.util.List;

  public class Triangle{
  
      public static void main(String[] args) {
           Solution solution = new Triangle().new Solution();
      }
      
      
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          //DP:
/*    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        dp[0][0] = triangle.get(0).get(0);
        int min = dp[0][0];
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> lists = triangle.get(i);
            min = Integer.MAX_VALUE;
            for (int j = 0; j < lists.size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + lists.get(j);
                } else if (j == lists.size()-1) {
                    dp[i][j] = dp[i-1][j-1] + lists.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + lists.get(j);
                }
                if (min > dp[i][j]) {
                    min = dp[i][j];
                }
            }
        }
        return min;
    }*/

          //DP + space optimize
/*    public int minimumTotal(List<List<Integer>> triangle) {
      int[] dp = new int[triangle.size()];
      dp[0] = triangle.get(0).get(0);
      for (int i = 1; i < triangle.size(); i++) {
          List<Integer> lists = triangle.get(i);
          for (int j = lists.size()-1; j >= 0; j--) {
              if (j == lists.size()-1) {
                  dp[j] = dp[j-1] + lists.get(j);
              } else if (j == 0) {
                  dp[j] = dp[j] + lists.get(j);
              } else {
                  dp[j] = Math.min(dp[j], dp[j-1]) + lists.get(j);
              }
          }
      }
      int min = Integer.MAX_VALUE;
      for (int item : dp) {
          if (min > item) min = item;
      }
      return min;
    }*/

    public int minimumTotal(List<List<Integer>> triangle) {
      int[] dp = new int[triangle.size()+1];
      for (int i = triangle.size()-1; i >= 0; i--) {
          List<Integer> lists = triangle.get(i);
          for (int j = 0; j < lists.size(); j++) {
              dp[j] = Math.min(dp[j], dp[j+1]) + lists.get(j);
          }
      }
      return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }