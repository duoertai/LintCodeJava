package BinaryTreePreorderTraversal;

import Common.TreeNode;

import java.util.ArrayList;

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
public class Solution1 {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        helper(res, root);

        return res;
    }

    public void helper(ArrayList<Integer> res, TreeNode root){
        if(root == null)
            return;

        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);

        return;
    }
}
