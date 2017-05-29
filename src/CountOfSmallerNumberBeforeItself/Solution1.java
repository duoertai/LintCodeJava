package CountOfSmallerNumberBeforeItself;

import java.util.ArrayList;

/**
 * Created by ertaiduo on 5/28/17.
 */
public class Solution1 {
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(A == null || A.length == 0)
            return res;

        SegmentTreeNode root = build(0, 10001);

        for(int i = 0; i < A.length; i++){
            res.add(query(root, 0, A[i] - 1));
            modify(root, A[i]);
        }

        return res;
    }

    class SegmentTreeNode{
        public int start;
        public int end;
        public int count;
        public SegmentTreeNode left;
        public SegmentTreeNode right;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.count = 0;
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

    public int query(SegmentTreeNode root, int start, int end){
        if(start > end || start > root.end || end < root.start)
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

    public void modify(SegmentTreeNode root, int num){
        if(num > root.end || num < root.start)
            return;

        if(root.start == root.end && root.start == num){
            root.count++;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;

        if(num <= mid)
            modify(root.left, num);
        else
            modify(root.right, num);

        root.count = root.left.count + root.right.count;

        return;
    }
}
