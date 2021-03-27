//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 491 👎 0


package com.martin.leetcode.editor.cn;


public class RotateList{
    public static void main(String[] args) {
       Solution solution = new RotateList().new Solution();
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
/*    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = getLen(head);
        ListNode[] nodes = new ListNode[len];
        for (int i = 0; i < len; i++) {
            nodes[(i+k) % len] = head;
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < len; i++) {
            cur.next = nodes[i];
            cur = nodes[i];
        }
        cur.next = null;
        return dummy.next;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }*/

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode node = head;
        int len = 0;
        while (node.next != null) {
            node = node.next;
            len++;
        }
        node.next = head;
        k %= (len+1);
        int times = len - k;
        while (times -- > 0) {
            head = head.next;
        }
        ListNode nHead = head.next;
        head.next = null;
        return nHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
