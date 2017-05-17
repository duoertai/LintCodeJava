package IntersectionOfTwoLinkedLists;

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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here

        if(headA == null || headB == null)
            return null;

        ListNode p1 = headA;
        ListNode p2 = headB;

        int len1 = 0;
        int len2 = 0;

        while(p1 != null){
            len1++;
            p1 = p1.next;
        }

        while(p2 != null){
            len2++;
            p2 = p2.next;
        }

        p1 = headA;
        p2 = headB;

        if(len1 > len2){
            for(int i = 0; i < len1 - len2; i++)
                p1 = p1.next;
        }
        else{
            for(int i = 0; i < len2 - len1; i++)
                p2 = p2.next;
        }

        while(p1 != null && p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}