//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 825 👎 0


package com.martin.leetcode.editor.cn;


public class ReverseNodesInKGroup{
    public static void main(String[] args) {
       Solution solution = new ReverseNodesInKGroup().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
/*    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode p = head;
        ListNode lastEnd = null;
        boolean isUpdate = false;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (p != null) {
            stack.push(p);
            p = p.next;
            if (stack.size() == k) {
                ListNode top = stack.pop();
                if (!isUpdate) {
                    head = top;
                    isUpdate = true;
                }
                if (lastEnd != null) lastEnd.next = top;
                ListNode node;
                while (!stack.isEmpty()) {
                    node = stack.pop();
                    top.next = node;
                    top = node;
                }
                lastEnd = top;
            }
        }
        if (lastEnd != null) {
            if (!stack.isEmpty()) {
                lastEnd.next = stack.getLast();
            } else {
                lastEnd.next = null;
            }
        }
        return head;
    }*/

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) return head;
            end = end.next;
        }
        ListNode newHead = reverse(start, end);
        start.next = reverseKGroup(end, k);
        return newHead;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode cur = start;
        while (cur != end) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
