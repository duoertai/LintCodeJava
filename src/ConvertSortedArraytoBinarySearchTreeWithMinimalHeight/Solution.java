package ConvertSortedArraytoBinarySearchTreeWithMinimalHeight;

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
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if(A == null || A.length == 0)
            return null;

        TreeNode root = sortedArrayToBST(A, 0, A.length - 1);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] A, int start, int end){
        if(start > end)
            return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(A[mid]);
        TreeNode left = sortedArrayToBST(A, start, mid - 1);
        TreeNode right = sortedArrayToBST(A, mid + 1, end);
        root.left = left;
        root.right = right;

        return root;
    }

}
