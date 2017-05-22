package RotateList;

import Common.ListNode;

public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head == null || head.next == null)
            return head;

        int len = 0;
        ListNode p = head;
        while(p != null){
            len++;
            p = p.next;
        }

        k = k % len;

        if(k == 0)
            return head;

        p = head;
        for(int i = 0; i < len - k - 1; i++)
            p = p.next;

        ListNode new_head = p.next;
        p.next = null;
        p = new_head;
        while(p.next != null)
            p = p.next;
        p.next = head;

        return new_head;
    }
}
