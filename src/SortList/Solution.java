package SortList;

import Common.ListNode;

public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        head = sortList(head);
        head2 = sortList(head2);

        head = merge(head, head2);

        return head;
    }

    public ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null)
            return h2;
        if(h2 == null)
            return h1;

        ListNode fakehead = new ListNode(0);
        ListNode p = fakehead;

        while(h1 != null || h2 != null){
            if(h1 == null){
                p.next = h2;
                h2 = h2.next;
                p = p.next;
            }
            else if(h2 == null){
                p.next = h1;
                h1 = h1.next;
                p = p.next;
            }
            else{
                if(h1.val < h2.val){
                    p.next = h1;
                    h1 = h1.next;
                    p = p.next;
                }
                else{
                    p.next = h2;
                    h2 = h2.next;
                    p = p.next;
                }
            }
        }

        return fakehead.next;
    }

}

