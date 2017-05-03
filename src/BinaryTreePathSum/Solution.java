package BinaryTreePathSum;

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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(root == null)
            return res;

        List<Integer> temp = new ArrayList<Integer>();

        helper(res, temp, root, target);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> temp, TreeNode root, int target){

        if(root.left == null && root.right == null){
            if(target == root.val){
                temp.add(root.val);
                List<Integer> line = new ArrayList<Integer>(temp);
                temp.remove(temp.size() - 1);
                res.add(line);
            }
            return;
        }


        if(root.left != null){
            temp.add(root.val);
            helper(res, temp, root.left, target - root.val);
            temp.remove(temp.size() - 1);
        }

        if(root.right != null){
            temp.add(root.val);
            helper(res, temp, root.right, target - root.val);
            temp.remove(temp.size() - 1);
        }

        return;
    }

}