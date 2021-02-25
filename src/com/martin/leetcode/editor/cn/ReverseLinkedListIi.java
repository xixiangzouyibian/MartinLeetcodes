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
/*    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 1;
        ListNode pre = dummy, cur = head;
        ListNode leftNode = dummy;
        while (count <= right) {
            if (count > left) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            } else {
                if (count == left) {
                    leftNode = pre;
                }
                pre = cur;
                cur = cur.next;
            }
            count++;
        }
        ListNode next = leftNode.next;
        leftNode.next = pre;
        next.next = cur;

        return dummy.next;
    }*/

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseTopN(head, right);
        }
        ListNode last = reverseBetween(head.next, left-1, right-1);
        head.next = last;
        return head;
    }

    ListNode next;
    private ListNode reverseTopN(ListNode head, int N) {
        if (N == 1) {
            next = head.next;
            return head;
        }
        ListNode last = reverseTopN(head.next, N-1);
        head.next.next = head;
        head.next = next;
        return last;
    }

    /*    private ListNode reverseAll(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseAll(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}
