//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1238 👎 0


package com.martin.leetcode.editor.cn;


public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
       Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
/*    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cursor = head;
        while (cursor != null) {
            nodes.add(cursor);
            cursor = cursor.next;
        }
        int preNodeIndex = nodes.size()-n-1;
        if (preNodeIndex == -1) {
            dummy.next = head.next;
            return dummy.next;
        }

        ListNode node = nodes.get(preNodeIndex);
        node.next = node.next.next;
        return head;
    }*/

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode quick = head;

        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
