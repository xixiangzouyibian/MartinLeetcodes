//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 726 👎 0


package com.martin.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RotateImage{
    public static void main(String[] args) {
       Solution solution = new RotateImage().new Solution();
       solution.rotate(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public void rotate(int[][] matrix) {
        int len = matrix.length;
        Map<Pair, Pair> expected = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                expected.put(new Pair(i, j), new Pair(j, len-i-1));
            }
        }
        Map<Pair, Pair> exchangeRecord = new HashMap<>();
        for (Pair key : expected.keySet()) {
            Pair newKey = expected.get(key);
            Pair newValue = getRoot(exchangeRecord, key);
            if (!newKey.equals(newValue)) {
                swap(matrix, newKey, newValue);
            }
            exchangeRecord.put(expected.get(key), key);
        }
    }*/

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        Map<Pair, Pair> exchangeRecord = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Pair key = new Pair(i, j);
                Pair value = new Pair(j, len-i-1);

                Pair root = getRoot(exchangeRecord, key);
                if (!root.equals(value)) {
                    swap(matrix, root, value);
                }
                exchangeRecord.put(value, key);
            }
        }
    }

    Pair getRoot(Map<Pair, Pair> map, Pair key) {
        if (!map.containsKey(key)) return key;
        return getRoot(map, map.get(key));
    }

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private void swap(int[][] matrix, Pair pair1, Pair pair2) {
        int temp = matrix[pair1.x][pair1.y];
        matrix[pair1.x][pair1.y] = matrix[pair2.x][pair2.y];
        matrix[pair2.x][pair2.y] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
