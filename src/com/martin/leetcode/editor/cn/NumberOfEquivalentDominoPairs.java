//给你一个由一些多米诺骨牌组成的列表 dominoes。 
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。 
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 
//b==c。 
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。 
//
// 
//
// 示例： 
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dominoes.length <= 40000 
// 1 <= dominoes[i][j] <= 9 
// 
// Related Topics 数组 
// 👍 100 👎 0


package com.martin.leetcode.editor.cn;


public class NumberOfEquivalentDominoPairs{
    public static void main(String[] args) {
       Solution solution = new NumberOfEquivalentDominoPairs().new Solution();
        System.out.println(solution.numEquivDominoPairs(new int[][] {{1,2},{2,1},{3,4}}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public int numEquivDominoPairs(int[][] dominoes) {
        int len = dominoes.length;
        Map<Pair, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Pair pair = new Pair(dominoes[i][0], dominoes[i][1]);
            map.put(pair, map.getOrDefault(pair, -1)+1);
        }
        int num = 0;
        for (int n : map.values()) {
            if (n == 0) continue;
            num += (n+1) * n / 2;
        }
        return num;
    }

    class Pair {
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
            return (x == pair.x && y == pair.y) || (y == pair.x && x == pair.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y) + Objects.hash(y, x);
        }
    }*/

/*    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            int num1 = dominoe[0] * 10 + dominoe[1];
            int num2 = dominoe[1] * 10 + dominoe[0];
            if (map.containsKey(num1)) {
                map.put(num1, map.get(num1) + 1);
            } else if (map.containsKey(num2)) {
                map.put(num2, map.get(num2) + 1);
            } else {
                map.put(num1, 0);
            }
        }
        int num = 0;
        for (int n : map.values()) {
            if (n == 0) continue;
            num += (n+1) * n / 2;
        }
        return num;
    }*/

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
