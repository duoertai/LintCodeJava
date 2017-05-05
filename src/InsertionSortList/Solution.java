package InsertionSortList;

import Common.ListNode;

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if(head == null || head.next == null)
            return head;

        ListNode fakehead = new ListNode(0);

        ListNode p = fakehead;

        while(head != null){
            while(p.next != null && p.next.val < head.val)
                p = p.next;

            ListNode temp = head.next;
            head.next = p.next;
            p.next = head;

            head = temp;
            p = fakehead;
        }

        return fakehead.next;
    }
}