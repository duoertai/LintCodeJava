package ConstructBinaryTreeFromPreorderAndInorderTraversal;

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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here

        if(preorder == null || preorder.length == 0)
            return null;

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end){

        if(pre_start > pre_end || in_start > in_end)
            return null;

        TreeNode root = new TreeNode(preorder[pre_start]);
        int index = in_start;
        for(; index <= in_end; index++)
            if(inorder[index] == preorder[pre_start])
                break;

        TreeNode left = buildTree(preorder, pre_start + 1, pre_start + index - in_start, inorder, in_start, index - 1);
        TreeNode right = buildTree(preorder, pre_end - in_end + index + 1, pre_end, inorder, index + 1, in_end);

        root.left = left;
        root.right = right;

        return root;
    }

}
