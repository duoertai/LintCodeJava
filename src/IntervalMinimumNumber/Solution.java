package IntervalMinimumNumber;

import Common.Interval;

import java.util.ArrayList;

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A, ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(A == null || A.length == 0 || queries == null || queries.size() == 0)
            return res;

        SegmentTreeNode root = build(0, A.length - 1);

        for(int i = 0; i < A.length; i++){
            modify(root, i, A[i]);
        }

        for(Interval interval: queries){
            res.add(query(root, interval.start, interval.end));
        }

        return res;
    }

    class SegmentTreeNode{
        public int start;
        public int end;
        public int min;
        public SegmentTreeNode left;
        public SegmentTreeNode right;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.min = Integer.MAX_VALUE;
            this.left = null;
            this.right = null;
        }
    }

    public SegmentTreeNode build(int start, int end){
        if(start > end)
            return null;

        if(start == end)
            return new SegmentTreeNode(start, end);

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        int mid = start + (end - start) / 2;
        SegmentTreeNode left = build(start, mid);
        SegmentTreeNode right = build(mid + 1, end);
        root.left = left;
        root.right = right;

        return root;
    }

    public void modify(SegmentTreeNode root, int index, int val){
        if(index < root.start || index > root.end)
            return;

        if(root.start == root.end && root.start == index){
            root.min = val;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if(index <= mid){
            modify(root.left, index, val);
        }
        else{
            modify(root.right, index, val);
        }

        root.min = Math.min(root.left.min, root.right.min);
        return;
    }

    public int query(SegmentTreeNode root, int start, int end){
        if(start > end)
            return Integer.MAX_VALUE;

        start = Math.max(start, root.start);
        end = Math.min(end, root.end);

        if(root.start == start && root.end == end)
            return root.min;

        int mid = root.start + (root.end - root.start) / 2;

        if(end <= mid)
            return query(root.left, start, end);
        else if(start > mid)
            return query(root.right, start, end);
        else{
            int left = query(root.left, start, mid);
            int right = query(root.right, mid + 1, end);

            return Math.min(left, right);
        }
    }

}
