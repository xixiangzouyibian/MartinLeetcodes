//English description is not available for the problem. Please switch to 
//Chinese. Related Topics 栈 设计 👍 268 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.LinkedList;

public class BaoHanMinhanShuDeZhanLcof{
    public static void main(String[] args) {
/*        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min);*/
    }
    //leetcode submit region begin(Prohibit modification and deletion)
 class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
        stack.push(Integer.MAX_VALUE);
        min.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        stack.push(x);
        min.push(Math.min(min.peek(), x));
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}