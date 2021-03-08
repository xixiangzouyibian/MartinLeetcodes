package com.martin.leetcode.editor.cn;

import java.util.*;

/**
 * Created by Martin Zhou on 2021/3/7
 */
public class CountRestrictedPaths {
    public static void main(String[] args) {
        System.out.println(new CountRestrictedPaths().countRestrictedPaths(5, new int[][] {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}}));
    }

    int mod = (int)1e9+7;

    public int countRestrictedPaths(int n, int[][] edges) {
        ArrayList<int[]>[] map = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(new int[] {edge[1], edge[2]});
            map[edge[1]].add(new int[] {edge[0], edge[2]});
        }

        int[] distance = new int[n+1];
        naiveDijkstra(n, map, distance);

        return (int) dfs(n, 1, map, distance, new long[n+1]);
    }

    private long dfs(int n, int start, ArrayList<int[]>[] map, int[] distance, long[] dp) {
        if (start == n) return 1;
        if (dp[start] != 0) return dp[start];
        long res = 0;
        for (int[] next : map[start]) {
            if (distance[next[0]] >= distance[start]) continue;
            res += dfs(n, next[0], map, distance, dp);
        }
        dp[start] = res % mod;
        return dp[start];
    }

    /**
     * 89 ms	69.8 MB
     */
/*    private void dijkstra(int n, ArrayList<int[]>[] map, int[] distance) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[] {n, 0}); // node num is n, and distance is 0 -> will calculate least dist from each node to the last node
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int weight = cur[1];
            if (distance[node] != 0) continue;
            distance[node] = weight;
            for (int[] next : map[node]) {
                if (distance[next[0]] != 0 || next[0] == n) continue;
                queue.offer(new int[] {next[0], next[1] + weight});
            }
        }
    }*/

    /**
     * 57 ms	65.5 MB
     */
    private void dijkstra(int n, ArrayList<int[]>[] map, int[] distance) {
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance, 0x3f3f3f3f);
        distance[n] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[] {n, 0}); // node num is n, and distance is 0 -> will calculate least dist from each node to the last node
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            if (visited[node]) continue;
            visited[node] = true;
            for (int[] next : map[node]) {
                if (distance[next[0]] > distance[node] + next[1]) {
                    distance[next[0]] = distance[node] + next[1];
                    queue.offer(new int[] {next[0], distance[next[0]]});
                }
            }
        }
    }

    /**
     * 2211 ms	65.1 MB
     */
    private void naiveDijkstra(int n, ArrayList<int[]>[] map, int[] distance) {
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance, 0x3f3f3f3f);
        distance[n] = 0;

        for (int i = 0; i < n; i++) {
            int cur = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (cur == -1 || distance[cur] > distance[j])) { // found not visited, but is the shortest distance
                    cur = j;
                }
            }
            visited[cur] = true;
            for (int[] next : map[cur]) {
                distance[next[0]] = Math.min(distance[next[0]], distance[cur] + next[1]);
            }
        }
    }

    /**
     * 43 ms	59.7 MB
     */
    private void spfa(int n, ArrayList<int[]>[] map, int[] distance) {
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance, 0x3f3f3f3f);
        distance[n] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = false;
            for (int[] next : map[cur]) {
                if (distance[next[0]] > distance[cur] + next[1]) {
                    distance[next[0]] = distance[cur] + next[1];
                    if (!visited[next[0]]) {
                        visited[next[0]] = true;
                        queue.offer(next[0]);
                    }
                }
            }
        }
    }

    /**
     * TLE N/A	N/A
     */
    private void bf(int n, ArrayList<int[]>[] map, int[] distance) {
        Arrays.fill(distance, 0x3f3f3f3f);
        distance[n] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int[] cur : map[j]) {
                    distance[j] = Math.min(distance[j], distance[cur[0]] + cur[1]);
                }
            }
        }
    }
}
