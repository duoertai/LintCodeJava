package ReverseLinkedListII;

import Common.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if(m == n)
            return head;
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;

        ListNode p1 = fakehead;
        ListNode p2 = fakehead;

        m--;

        while(m > 0){
            p1 = p1.next;
            m--;
        }

        while(n > 0){
            p2 = p2.next;
            n--;
        }

        ListNode head1 = fakehead;
        ListNode head2 = p1.next;
        ListNode head3 = p2.next;
        p1.next = null;
        p2.next = null;

        head2 = reverse(head2);
        ListNode p = fakehead;
        while(p.next != null)
            p = p.next;
        p.next = head2;

        while(p.next != null)
            p = p.next;
        p.next = head3;

        return fakehead.next;
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