//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 344 👎 0


package com.martin.leetcode.editor.cn;


public class PartitionList{
    public static void main(String[] args) {
       Solution solution = new PartitionList().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode smallTail = smallHead;
        ListNode bigTail = bigHead;
        while (head != null) {
            if (head.val < x) {
                smallTail = smallTail.next = head;
            } else {
                bigTail = bigTail.next = head;
            }
            head = head.next;
        }
        smallTail.next = bigHead.next;
        bigTail.next = null;
        return smallHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
