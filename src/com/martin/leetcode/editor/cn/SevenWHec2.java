//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 28 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SevenWHec2{
    public static void main(String[] args) {
       Solution solution = new SevenWHec2().new Solution();
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
    public ListNode sortList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = head;
        List<Integer> vals = new LinkedList<>();
        while (dummy != null) {
            vals.add(dummy.val);
            dummy = dummy.next;
        }

        Collections.sort(vals);
        head = new ListNode(vals.get(0));
        dummy = head;
        for (int i = 1; i < vals.size(); i++) {
            dummy.next = new ListNode(vals.get(i));
            dummy = dummy.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}