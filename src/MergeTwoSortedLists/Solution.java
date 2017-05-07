package MergeTwoSortedLists;

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode fakehead = new ListNode(0);
        ListNode p = fakehead;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1 != null || p2 != null){
            int num1 = Integer.MAX_VALUE;
            if(p1 != null)
                num1 = p1.val;

            int num2 = Integer.MAX_VALUE;
            if(p2 != null)
                num2 = p2.val;

            if(num1 < num2){
                p.next = new ListNode(num1);
                p1 = p1.next;
            }
            else{
                p.next = new ListNode(num2);
                p2 = p2.next;
            }

            p = p.next;
        }

        return fakehead.next;
    }
}