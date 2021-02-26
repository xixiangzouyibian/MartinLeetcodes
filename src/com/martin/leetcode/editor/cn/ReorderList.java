//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 520 👎 0


package com.martin.leetcode.editor.cn;


public class ReorderList{
    public static void main(String[] args) {
       Solution solution = new ReorderList().new Solution();
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
    public void reorderList(ListNode head) {
        ListNode slow = new ListNode();
        slow.next = head;
        ListNode quick = new ListNode();
        quick.next = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow.next);
        slow.next = null;
        while (right != null) {
            ListNode cur = right;
            right = right.next;
            ListNode next = left.next;
            left.next = cur;
            cur.next = next;
            left = next;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
