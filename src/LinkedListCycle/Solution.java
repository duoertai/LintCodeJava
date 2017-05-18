package LinkedListCycle;

import Common.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        // write your code here
        if(head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }

        return false;
    }
}

