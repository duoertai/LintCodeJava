package BinaryTreePreorderTraversal;

import Common.TreeNode;

import java.util.ArrayList;
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
 */
public class Solution2 {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode p = stack.pop();
            res.add(p.val);

            if(p.right != null)
                stack.push(p.right);

            if(p.left != null)
                stack.push(p.left);
        }

        return res;
    }
}
