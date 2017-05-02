package RemoveLinkedListElements;

import Common.ListNode;

public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if(head == null)
            return head;

        ListNode fakehead = new ListNode(0);
        fakehead.next = head;

        ListNode p = fakehead;

        while(p.next != null){
            while(p.next != null && p.next.val != val){
                p = p.next;
            }

            if(p.next != null){
                p.next = p.next.next;
            }
        }

        return fakehead.next;
    }
}
