package BinaryTreeSerialization;

import Common.TreeNode;

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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null)
            return "";

        StringBuilder res = new StringBuilder();

        LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        curr.offer(root);

        while(!curr.isEmpty()){
            TreeNode temp = curr.poll();

            if(temp == null){
                res.append('#').append(',');
            }
            else{
                res.append(temp.val).append(',');
                next.offer(temp.left);
                next.offer(temp.right);
            }

            if(curr.isEmpty()){
                curr = next;
                next = new LinkedList<TreeNode>();
            }
        }

        return res.substring(0, res.length() - 1);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data == null || data.length() == 0)
            return null;

        String[] nodes = data.split(",");
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        int i = 1;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            String left_str = nodes[i++];
            if(!left_str.equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(left_str));
                temp.left = left;
                queue.offer(left);
            }

            String right_str = nodes[i++];
            if(!right_str.equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(right_str));
                temp.right = right;
                queue.offer(right);
            }
        }

        return root;
    }
}

