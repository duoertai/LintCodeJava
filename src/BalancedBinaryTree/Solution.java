package BalancedBinaryTree;

import Common.TreeNode;

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
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null)
            return true;

        if(!isBalanced(root.left) || !isBalanced(root.right))
            return false;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.abs(left - right) <= 1;
    }

    public int getDepth(TreeNode root){
        if(root == null)
            return 0;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.max(left, right) + 1;
    }
}