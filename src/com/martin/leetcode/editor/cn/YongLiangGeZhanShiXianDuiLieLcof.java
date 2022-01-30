////English description is not available for the problem. Please switch to 
////Chinese. Related Topics 栈 设计 队列 👍 414 👎 0
//

  
package com.martin.leetcode.editor.cn;

import java.util.LinkedList;

public class YongLiangGeZhanShiXianDuiLieLcof{
  public static void main(String[] args) {
      CQueue solution = new YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
/*class CQueue {

      private Stack<Integer> stack1;
      private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty())
            return stack2.pop();

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}*/

class CQueue {

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty())
            return stack2.pop();

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}