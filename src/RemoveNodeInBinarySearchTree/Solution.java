package RemoveNodeInBinarySearchTree;

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
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if(root == null)
            return null;

        if(root.val == value){
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;

            TreeNode next_root = root.left;
            if(next_root.right == null){
                next_root.right = root.right;
                return next_root;
            }
            else{
                TreeNode p1 = next_root;
                TreeNode p2 = next_root.right;
                while(p2.right != null){
                    p1 = p1.right;
                    p2 = p2.right;
                }

                p1.right = p2.left;
                p2.left = null;
                p2.left = root.left;
                p2.right = root.right;
                return p2;
            }
        }

        if(root.val > value){
            TreeNode next_left = removeNode(root.left, value);
            root.left = next_left;
        }
        else{
            TreeNode next_right = removeNode(root.right, value);
            root.right = next_right;
        }

        return root;
    }

}
