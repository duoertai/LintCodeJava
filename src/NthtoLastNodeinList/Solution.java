package NthtoLastNodeinList;

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
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list.
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode p1 = head;

        for(int i = 0; i < n; i++)
            p1 = p1.next;

        ListNode p2 = head;

        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
