package RemoveDuplicatesFromSortedListII;

import Common.ListNode;

public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here

        if(head == null || head.next == null)
            return head;

        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        ListNode p1 = fakehead;
        ListNode p2 = head;

        while(p2 != null && p2.next != null){
            if(p2.val != p2.next.val){
                p1 = p1.next;
                p2 = p2.next;
            }
            else{
                while(p2 != null && p2.next != null && p2.val == p2.next.val){
                    p2 = p2.next;
                }
                p2 = p2.next;
                p1.next = p2;
            }
        }

        return fakehead.next;
    }
}

