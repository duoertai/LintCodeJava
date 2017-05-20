package PalindromeLinkedList;

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
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here

        if(head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p = head;
        while(p.next != slow)
            p = p.next;
        p.next = null;

        ListNode head2 = slow;
        head2 = reverse(head2);

        ListNode p1 = head;
        ListNode p2 = head2;

        while(p1 != null && p2 != null){
            if(p1.val != p2.val)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
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