package ReorderList;

import Common.ListNode;

public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        // write your code here
        if(head == null || head.next == null)
            return;

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
        ListNode head2 = reverse(slow);

        ListNode p1 = head;
        ListNode p2 = head2;

        ListNode fakehead = new ListNode(0);
        p = fakehead;

        while(p1 != null || p2 != null){
            if(p1 != null){
                ListNode temp = p1.next;
                p.next = p1;
                p = p.next;
                p1 = temp;
            }
            if(p2 != null){
                ListNode temp = p2.next;
                p.next = p2;
                p = p.next;
                p2 = temp;
            }
        }

        return;
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
