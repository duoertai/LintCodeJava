package ConvertSortedListToBalancedBST;

import Common.ListNode;
import Common.TreeNode;

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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here

        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        ListNode p = head;

        while(p.next != slow)
            p = p.next;
        p.next = null;

        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(slow.next);

        root.left = left;
        root.right = right;

        return root;
    }
}

