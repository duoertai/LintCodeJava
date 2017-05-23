package SegmentTreeBuildII;

public class Solution {
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if(A == null || A.length == 0)
            return null;

        return build(A, 0, A.length - 1);
    }

    public SegmentTreeNode build(int[] nums, int start, int end){
        if(start > end)
            return null;

        if(start == end)
            return new SegmentTreeNode(start, end, nums[start]);

        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
        int mid = start + (end - start) / 2;
        SegmentTreeNode left = build(nums, start, mid);
        SegmentTreeNode right = build(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        root.max = Math.max(left.max, right.max);

        return root;
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
