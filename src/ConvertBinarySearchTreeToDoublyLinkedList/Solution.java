package ConvertBinarySearchTreeToDoublyLinkedList;

import Common.DoublyListNode;
import Common.TreeNode;

import java.util.Stack;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // Write your code here

        if(root == null)
            return null;

        DoublyListNode fakehead = new DoublyListNode(0);
        DoublyListNode p = fakehead;

        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }

        while(!stack.isEmpty()){
            temp = stack.pop();
            p.next = new DoublyListNode(temp.val);
            p.next.prev = p;
            p = p.next;

            if(temp.right != null){
                temp = temp.right;

                while(temp != null){
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }

        fakehead.next.prev = null;
        return fakehead.next;
    }
}

