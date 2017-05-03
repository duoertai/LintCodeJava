package BinaryTreeLevelOrderTraversal;

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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(root == null)
            return res;

        LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        curr.offer(root);

        ArrayList<Integer> line = new ArrayList<Integer>();

        while(!curr.isEmpty()){
            TreeNode temp = curr.poll();
            line.add(temp.val);

            if(temp.left != null)
                next.offer(temp.left);

            if(temp.right != null)
                next.offer(temp.right);

            if(curr.isEmpty()){
                curr = next;
                next = new LinkedList<TreeNode>();
                res.add(line);
                line = new ArrayList<Integer>();
            }
        }

        return res;
    }
}