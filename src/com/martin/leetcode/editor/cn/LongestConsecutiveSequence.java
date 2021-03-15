//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 713 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence{
    public static void main(String[] args) {
       Solution solution = new LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[] {100,4,200,1,3,2}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (set.contains(num) && !set.contains(num-1)) {
                int temp = num;
                int count = 0;
                while (set.contains(temp)) {
                    count++;
                    temp++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }*/

    public int longestConsecutive(int[] nums) {
        UnionFind unionFind = new UnionFind(nums);
        for (int num : nums) {
            unionFind.union(num, num+1);
        }

        int res = 0;
        for (int num: nums) {
            res = Math.max(res, unionFind.find(num) - num + 1);
        }
        return res;
    }

    class UnionFind {
        Map<Integer, Integer> p;

        UnionFind(int[] arr) {
            p = new HashMap<>();
            for (int n : arr) {
                p.put(n, n);
            }
        }

        public Integer find(int id) {
            if (!p.containsKey(id)) return null;

            int root = p.get(id);
            if (root != id) {
                root = find(p.get(id));
                p.put(id, root);
            }
            return root;
        }

        public void union(int x, int y) {
            Integer xRoot = p.get(x);
            Integer yRoot = p.get(y);
            if (xRoot == null || yRoot == null) return;

            if (!xRoot.equals(yRoot)) {
                p.put(xRoot, yRoot);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
