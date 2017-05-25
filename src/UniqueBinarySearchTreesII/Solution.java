package UniqueBinarySearchTreesII;

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
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        List<TreeNode> res = new ArrayList<TreeNode>();

        if(n == 0){
            res.add(null);
            return res;
        }

        if(n == 1){
            res.add(new TreeNode(1));
            return res;
        }

        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();

        if(start > end){
            res.add(null);
            return res;
        }

        if(start == end){
            res.add(new TreeNode(start));
            return res;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }

        }
        return res;
    }
}
