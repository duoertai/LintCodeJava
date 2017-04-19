package BinaryTreeMaximumNode;

import Common.TreeNode;

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here

        if(root == null)
            return null;

        if(root.left == null && root.right == null)
            return root;

        TreeNode left_max = maxNode(root.left);
        TreeNode right_max = maxNode(root.right);

        TreeNode res = root;

        if(left_max != null && left_max.val > res.val)
            res = left_max;
        if(right_max != null && right_max.val > res.val)
            res = right_max;

        return res;
    }
}