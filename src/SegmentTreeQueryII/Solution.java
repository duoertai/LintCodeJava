package SegmentTreeQueryII;

public class Solution {
    public int query(SegmentTreeNode root, int start, int end) {
        if(start > end || root == null)
            return 0;

        start = Math.max(start, root.start);
        end = Math.min(end, root.end);

        if(root.start == start && root.end == end)
            return root.count;

        int mid = root.start + (root.end - root.start) / 2;

        if(end <= mid){
            return query(root.left, start, end);
        }
        else if(start > mid){
            return query(root.right, start, end);
        }
        else{
            int left = query(root.left, start, mid);
            int right = query(root.right, mid + 1, end);
            return left + right;
        }
    }

    public class SegmentTreeNode {
        public int start, end, count;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
}
