package SwapTwoNodesInLinkedList;

import Common.ListNode;

public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if(head == null || head.next == null || v1 == v2)
            return head;

        ListNode fakehead = new ListNode(0);
        fakehead.next = head;

        int index1 = 0;
        int index2 = 0;

        ListNode p1 = fakehead;
        ListNode p2 = fakehead;

        while(p1 != null && p1.next != null && p1.next.val != v1){
            p1 = p1.next;
            index1++;
        }

        if(p1 == null || p1.next == null)
            return head;

        while(p2 != null && p2.next != null && p2.next.val != v2){
            p2 = p2.next;
            index2++;
        }

        if(p2 == null || p2.next == null)
            return head;

        ListNode head2 = null;
        ListNode head3 = null;
        ListNode temp1 = null;
        ListNode temp2 = null;

        if(index1 < index2){
            head2 = p1.next;
            p1.next = null;
            head3 = p2.next;
            p2.next = null;
        }
        else{
            head2 = p2.next;
            p2.next = null;
            head3 = p1.next;
            p1.next = null;
        }

        temp1 = head2;
        head2 = head2.next;
        temp1.next = null;
        temp2 = head3;
        head3 = head3.next;
        temp2.next = null;

        ListNode p = fakehead;
        while(p.next != null)
            p = p.next;

        p.next = temp2;
        p = p.next;
        p.next = head2;
        while(p.next != null)
            p = p.next;
        p.next = temp1;
        p = p.next;
        p.next = head3;

        return fakehead.next;
    }
}
