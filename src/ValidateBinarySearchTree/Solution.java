package ValidateBinarySearchTree;

import Common.TreeNode;

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null)
            return true;

        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(TreeNode root, double lower, double upper){
        if(root == null)
            return true;

        if(root.val <= lower || root.val >= upper)
            return false;

        return isValidBST(root.left, lower, (double) root.val) && isValidBST(root.right, (double) root.val, upper);
    }
}
