package DeleteNodeintheMiddleofSinglyLinkedList;

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
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        while(node.next != null && node.next.next != null){
            node.val= node.next.val;
            node = node.next;
        }

        node.val = node.next.val;
        node.next = null;

        return;
    }
}