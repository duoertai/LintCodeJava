package ReverseNodesInKGroup;

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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null || head.next == null)
            return head;

        ListNode p = head;

        for(int i = 0; i < k - 1 && p != null; i++){
            p = p.next;
        }

        if(p == null)
            return head;

        ListNode next_head = p.next;
        p.next = null;
        head = reverse(head);
        next_head = reverseKGroup(next_head, k);

        p = head;
        while(p.next != null)
            p = p.next;

        p.next = next_head;

        return head;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        head.next = null;

        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;

        return curr;
    }

}