package HouseRobberIII;

import Common.TreeNode;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        // write your code here

        if(root == null)
            return 0;

        int[] res = rob(root);

        return Math.max(res[0], res[1]);
    }

    public int[] rob(TreeNode root){
        int[] res = new int[2];
        if(root == null)
            return res;

        int[] left = rob(root.left);
        int[] right = rob(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;

        return res;
    }

}
