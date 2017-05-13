package ConstructBinaryTreeFromInorderAndPostorderTraversal;

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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here

        if(inorder == null || inorder.length == 0)
            return null;

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int in_start, int in_end, int[] postorder, int post_start, int post_end){

        if(in_start > in_end || post_start > post_end)
            return null;

        TreeNode root = new TreeNode(postorder[post_end]);
        int index = in_start;
        for(; index <= in_end; index++)
            if(inorder[index] == postorder[post_end])
                break;

        TreeNode left = buildTree(inorder, in_start, index - 1, postorder, post_start, post_start + index - 1 - in_start);
        TreeNode right = buildTree(inorder, index + 1, in_end, postorder, post_end - in_end + index , post_end - 1);

        root.left = left;
        root.right = right;

        return root;
    }

}
