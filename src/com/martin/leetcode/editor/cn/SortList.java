//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1010 👎 0


package com.martin.leetcode.editor.cn;


public class SortList{
    public static void main(String[] args) {
       Solution solution = new SortList().new Solution();
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
    public ListNode sortList(ListNode head) {
        return merge(head);
    }

    /**
     * Merge Sort
     */
    private ListNode merge(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;

        return merge2Lists(merge(head), merge(midNext));
    }

    private ListNode getMid(ListNode head) {
        if (head.next == null) return head;

        ListNode slow = new ListNode();
        slow.next = head;
        ListNode quick = new ListNode();
        quick.next = head;

        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cursor = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cursor.next = l1;
                l1 = l1.next;
            } else {
                cursor.next = l2;
                l2 = l2.next;
            }
            cursor = cursor.next;
        }
        cursor.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

    /**
     * Heap Sort
     */
/*    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        while (head != null) {
            pq.offer(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cursor = dummy;
        while (!pq.isEmpty()) {
            cursor.next = pq.poll();
            cursor = cursor.next;
        }
        if (cursor != null && cursor.next != null) cursor.next = null;
        return dummy.next;
    }*/

    /**
     * Brute Force
     */
/*    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            int curVal = cur.val;
            ListNode cursor = dummy;
            while (cursor.next != null && curVal > cursor.next.val) {
                cursor = cursor.next;
            }
            ListNode temp = cur.next;
            ListNode next = cursor.next;
            cursor.next = cur;
            cur.next = next;
            cur = temp;
        }
        return dummy.next;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}
