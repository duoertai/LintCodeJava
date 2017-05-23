package SegmentTreeModify;

public class Solution {
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root == null || index < root.start || index > root.end)
            return;

        if(root.start == root.end && root.start == index){
            root.max = value;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if(index <= mid){
            modify(root.left, index, value);
        }
        else{
            modify(root.right, index, value);
        }

        root.max = Math.max(root.left.max, root.right.max);
        return;
    }

    public class SegmentTreeNode {
        public int start, end, max;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }
}
