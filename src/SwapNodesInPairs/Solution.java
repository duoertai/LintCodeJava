package SwapNodesInPairs;

import Common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if(head == null || head.next == null)
            return head;

        ListNode fakehead = new ListNode(0);
        fakehead.next = head;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        ListNode p = fakehead;

        while(next != null && next.next != null){
            prev.next = next;
            curr.next = prev;
            p.next = curr;
            p = p.next.next;
            prev = next;
            curr = next.next;
            next = curr.next;
        }

        prev.next = next;
        curr.next = prev;
        p.next = curr;

        return fakehead.next;
    }
}
