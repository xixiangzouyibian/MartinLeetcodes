//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1] 
//
// 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？ 
//
// 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 1 <= numCourses <= 10^5 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 693 👎 0


package com.martin.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule{
    public static void main(String[] args) {
       Solution solution = new CourseSchedule().new Solution();
        System.out.println(solution.canFinish(5, new int[][] {{1,0},{3,0},{2,1},{2,3},{4,2}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len <= 1) return true;
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int prerequisite = queue.poll();
            numCourses--;
            if (map.containsKey(prerequisite)) {
                for (int nextPre : map.get(prerequisite)) {
                    inDegree[nextPre]--;
                    if (inDegree[nextPre] == 0) {
                        queue.offer(nextPre);
                    }
                }
            }
        }

        return numCourses == 0;
    }*/

/*    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            if (!dfs(i, visited, map))
                return false;
        }

        return true;
    }

    public boolean dfs(int cur, boolean[] visited, Map<Integer, List<Integer>> map) {
        if (visited[cur])
            return false;

        visited[cur] = true;
        if (map.containsKey(cur)) {
            for (int next : map.get(cur)) {
                if (!dfs(next, visited, map))
                    return false;
            }
        }
        visited[cur] = false; // roll back status
        return true;
    }*/

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
        }

        int[] visited = new int[numCourses]; // 0 is never visit, -1 is other visited, 1 is cur visited
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, map))
                return false;
        }

        return true;
    }

    public boolean dfs(int cur, int[] visited, Map<Integer, List<Integer>> map) {
        if (visited[cur] == 1)
            return false;
        if (visited[cur] == -1)
            return true;

        visited[cur] = 1;
        if (map.containsKey(cur)) {
            for (int next : map.get(cur)) {
                if (!dfs(next, visited, map))
                    return false;
            }
        }
        visited[cur] = -1; // roll back status
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
