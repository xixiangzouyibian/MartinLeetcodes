package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/3/14
 */
public class FindCenter {
/*    public int findCenter(int[][] edges) {
        int len = edges.length;
        int n = len + 1;
        for (int i = 1; i <= n; i++) {
            UnionFind unionFind = new UnionFind(n);
            for (int[] edge : edges) {
                if (edge[0] == i || edge[1] == i) {
                    unionFind.union(edge[0], edge[1]);
                }
            }
            if (unionFind.count == len) return i;
        }
        return -1;
    }*/

    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] count = new int[n+1];
        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (count[i] == n-1) return i;
        }
        return -1;
    }
}

class UnionFind {
    int[] p;
    int count = 0;
    UnionFind(int n) {
        p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
    }
    public int find(int id) {
        if (p[id] != id) {
            p[id] = find(p[id]);
        }
        return p[id];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            p[xRoot] = yRoot;
            count++;
        }
    }
}