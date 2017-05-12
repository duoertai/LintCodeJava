package AddTwoNumbersII;

import Common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode res = add(l1, l2);

        return res;
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

    public ListNode add(ListNode l1, ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        int carry = 0;

        ListNode p = null;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1 != null || p2 != null){
            int num1 = 0;
            if(p1 != null){
                num1 = p1.val;
                p1 = p1.next;
            }

            int num2 = 0;
            if(p2 != null){
                num2 = p2.val;
                p2 = p2.next;
            }

            ListNode temp = new ListNode((num1 + num2 + carry) % 10);
            temp.next = p;
            p = temp;

            carry = (num1 + num2 + carry) / 10;
        }

        if(carry == 1){
            ListNode temp = new ListNode(1);
            temp.next = p;
            p = temp;
        }

        return p;
    }

}
