package BinaryTreePaths;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> res = new ArrayList<String>();

        if(root == null)
            return res;

        helper(res, root, "");

        return res;
    }

    public void helper(List<String> res, TreeNode root, String temp){
        if(root.left == null && root.right == null){
            String line = temp + root.val;
            res.add(line);
        }

        String next = temp + root.val + "->";

        if(root.left != null)
            helper(res, root.left, next);
        if(root.right != null)
            helper(res, root.right, next);

        return;
    }
}
