package BinaryTreeMaximumPathSum;

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
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;

        int[] res = maxSum(root);
        return res[1];
    }

    public int[] maxSum(TreeNode root){
        int[] res = new int[2];
        if(root == null){
            res[0] = 0;
            res[1] = Integer.MIN_VALUE;
            return res;
        }

        int[] left = maxSum(root.left);
        int[] right = maxSum(root.right);

        res[0] = Math.max(left[0], right[0]) + root.val;
        res[0] = Math.max(0, res[0]);
        res[1] = Math.max(left[1], right[1]);
        res[1] = Math.max(res[1], root.val + left[0] + right[0]);

        return res;
    }

}