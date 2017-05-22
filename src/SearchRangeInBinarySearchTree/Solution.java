package SearchRangeInBinarySearchTree;

import Common.TreeNode;

import java.util.ArrayList;

public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null || k2 < k1)
            return res;

        if(root.val == k1 && root.val == k2){
            res.add(k1);
            return res;
        }

        if(k1 > root.val)
            return searchRange(root.right, k1, k2);

        if(k2 < root.val)
            return searchRange(root.left, k1, k2);

        ArrayList<Integer> left = searchRange(root.left, k1, root.val - 1);
        res.addAll(left);
        res.add(root.val);
        ArrayList<Integer> right = searchRange(root.right, root.val + 1, k2);
        res.addAll(right);

        return res;
    }
}
