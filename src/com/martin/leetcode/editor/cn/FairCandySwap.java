//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。 
//
// 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。） 
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。 
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [1,1], B = [2,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：A = [1,2], B = [2,3]
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：A = [2], B = [1,3]
//输出：[2,3]
// 
//
// 示例 4： 
//
// 
//输入：A = [1,2,5], B = [2,4]
//输出：[5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= B.length <= 10000 
// 1 <= A[i] <= 100000 
// 1 <= B[i] <= 100000 
// 保证爱丽丝与鲍勃的糖果总量不同。 
// 答案肯定存在。 
// 
// Related Topics 数组 
// 👍 96 👎 0


package com.martin.leetcode.editor.cn;


import java.util.Arrays;

public class FairCandySwap{
    public static void main(String[] args) {
       Solution solution = new FairCandySwap().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for (int k : A) {
            sumA += k;
        }
        int sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int k : B) {
            sumB += k;
            set.add(k);
        }
        int sum = (sumA + sumB) >> 1;
        int diff = sum - sumA;
        for (int j : A) {
            int target = diff + j;
            if (target > 0 && set.contains(target)) {
                return new int[]{j, target};
            }
        }
        return new int[] {};
    }*/

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) >> 1;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;
        while (true) {
            if (A[i] - B[j] == delta) {
                return new int[] {A[i], B[j]};
            } else if (A[i] - B[j] > delta) {
                j++;
            } else {
                i++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}