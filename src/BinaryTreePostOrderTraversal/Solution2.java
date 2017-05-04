package BinaryTreePostOrderTraversal;

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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode prev = null;

        stack.push(root);

        while(!stack.isEmpty()){
            curr = stack.peek();

            if(prev == null || prev.left == curr || prev.right == curr){
                if(curr.left != null)
                    stack.push(curr.left);
                else if(curr.right != null)
                    stack.push(curr.right);
            }

            else if(curr.left == prev){
                if(curr.right != null)
                    stack.push(curr.right);
            }

            else{
                res.add(curr.val);
                stack.pop();
            }

            prev = curr;
        }

        return res;
    }
}
