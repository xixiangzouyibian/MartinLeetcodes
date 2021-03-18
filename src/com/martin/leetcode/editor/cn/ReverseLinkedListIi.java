//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 681 👎 0


package com.martin.leetcode.editor.cn;


public class ReverseLinkedListIi{
    public static void main(String[] args) {
       Solution solution = new ReverseLinkedListIi().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cursor = dummy;
        for (int i = 1; i < left; i++) cursor = cursor.next;

        ListNode a = cursor.next, b = a.next;
        for (int i = 0; i < right-left; i++) {
            ListNode temp = b.next;
            b.next = a;
            a = b;
            b = temp;
        }
        cursor.next.next = b;
        cursor.next = a;

        return dummy.next;
    }

/*    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseTopK(head, right);
        }
        head.next = reverseBetween(head.next, left-1, right-1);
        return head;
    }

    ListNode next;
    private ListNode reverseTopK(ListNode node, int k) {
        if (k == 1) {
            next = node.next;
            return node;
        }
        ListNode nHead = reverseTopK(node.next, k-1);
        node.next.next = node;
        node.next = next;
        return nHead;
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)

}
