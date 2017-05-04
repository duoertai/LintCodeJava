package ConvertBSTToGreaterTree;

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
     * @param root the root of binary tree
     * @return the new root
     */
    public TreeNode convertBST(TreeNode root) {
        // Write your code here

        if(root == null)
            return null;

        Num sum = new Num(0);
        helper(root, sum);

        return root;
    }

    public class Num{
        int num;
        public Num(int num){
            this.num = num;
        }
    }

    public void helper(TreeNode root, Num sum){
        if(root == null)
            return;

        helper(root.right, sum);
        root.val += sum.num;
        sum.num = root.val;
        helper(root.left, sum);

        return;
    }

}
