package BinarySearchTreeIterator;

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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */
public class BSTIterator {
    //@param root: The root of binary tree.

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        // write your code here
        this.stack = new Stack<TreeNode>();

        if(root == null)
            return;

        TreeNode p = root;

        while(p != null){
            stack.push(p);
            p = p.left;
        }

        return;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode p = this.stack.pop();
        TreeNode res = p;

        if(p.right != null){
            p = p.right;
            while(p != null){
                stack.push(p);
                p = p.left;
            }
        }

        return res;
    }
}
