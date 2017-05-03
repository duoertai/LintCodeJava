package BinaryTreeInorderTraversal;

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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;

        while(p != null){
            stack.push(p);
            p = p.left;
        }

        while(!stack.isEmpty()){
            p = stack.pop();
            res.add(p.val);

            if(p.right != null){
                p = p.right;

                while(p != null){
                    stack.push(p);
                    p = p.left;
                }
            }
        }

        return res;
    }
}