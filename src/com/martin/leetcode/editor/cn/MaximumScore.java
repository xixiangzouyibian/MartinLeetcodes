package com.martin.leetcode.editor.cn;

/**
 * Created by Martin Zhou on 2021/3/15
 */
public class MaximumScore {
    public static void main(String[] args) {
        System.out.println(new MaximumScore().maximumScore(new int[] {1,4,3,7,4,5}, 3));
    }

/*    public int maximumScore(int[] nums, int k) {
        int len = nums.length;

        int[] n = new int[len+2];
        System.arraycopy(nums, 0, n, 1, len);

        int[] l = new int[len+2];
        int[] r = new int[len+2];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i <= len; i++) {
            while (n[stack.peek()] >= n[i]) {
                stack.pop();
            }
            l[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        stack.push(len+1);
        for (int i = len; i > 0; i--) {
            while (n[stack.peek()] >= n[i]) {
                stack.pop();
            }
            r[i] = stack.peek();
            stack.push(i);
        }

        int res = 0;
        k++;
        for (int i = 1; i <= len; i++) {
            if (l[i] < k && k < r[i]) { // it is (l, r), not [l, r]
                res = Math.max(res, (r[i] - l[i] - 1) * n[i]);
            }
        }
        return res;
    }*/

    public int maximumScore(int[] nums, int k) {
        int l = k, r = k, t = nums[k];
        int len = nums.length;
        int res = 0;
        while (true) {
            while (l >= 0 && nums[l] >= t) l--;
            while (r < len && nums[r] >= t) r++;
            res = Math.max(res, (r - l - 1) * t);

            if (l == -1 && r == len) break;
            if (l == -1) {
                t = nums[r];
            } else if (r == len) {
                t = nums[l];
            } else {
                t = Math.max(nums[l], nums[r]);
            }
        }

        return res;
    }

}
