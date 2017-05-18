package LowestCommonAncestor;

import Common.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null)
            return null;

        if(root == A)
            return A;
        if(root == B)
            return B;

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if(left == null)
            return right;
        else if(right == null)
            return left;
        else
            return root;
    }
}
