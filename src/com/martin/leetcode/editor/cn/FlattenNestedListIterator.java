//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
// Related Topics 栈 设计 
// 👍 272 👎 0


package com.martin.leetcode.editor.cn;


import java.util.*;

public class FlattenNestedListIterator{
    public static void main(String[] args) {
//       Solution solution = new FlattenNestedListIterator().new Solution();
    }

public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*public class NestedIterator implements Iterator<Integer> {
    List<Integer> res;
    int count = 0;
    int cap = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        res = new ArrayList<>();
        dfs(nestedList);
        cap = res.size();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger()) {
                dfs(ni.getList());
            } else {
                res.add(ni.getInteger());
            }
        }
    }

    @Override
    public Integer next() {
        return res.get(count++);
    }

    @Override
    public boolean hasNext() {
        return count < cap;
    }
}*/

public class NestedIterator implements Iterator<Integer> {

    Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        for (int i = nestedList.size()-1; i >= 0; i--) {
            stack.offerLast(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return Objects.requireNonNull(stack.pollLast()).getInteger();
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            if (stack.peekLast().isInteger()) {
                return true;
            } else {
                NestedInteger ni = stack.pollLast();
                List<NestedInteger> list = ni.getList();
                for (int i = list.size()-1; i >=0; i--) {
                    stack.offerLast(list.get(i));
                }
                return hasNext();
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
