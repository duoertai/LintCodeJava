package BinaryTreeZigzagLevelOrderTraversal;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

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
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;

        ArrayList<Integer> line = new ArrayList<Integer>();
        LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        boolean l2r = false;
        curr.offerLast(root);

        while(!curr.isEmpty()){
            TreeNode temp = curr.pollFirst();

            line.add(temp.val);

            if(l2r){
                if(temp.right != null)
                    next.offerFirst(temp.right);
                if(temp.left != null)
                    next.offerFirst(temp.left);
            }
            else{
                if(temp.left != null)
                    next.offerFirst(temp.left);
                if(temp.right != null)
                    next.offerFirst(temp.right);
            }

            if(curr.isEmpty()){
                curr = next;
                next = new LinkedList<TreeNode>();
                res.add(line);
                line = new ArrayList<Integer>();
                l2r = !l2r;
            }
        }

        return res;
    }
}
