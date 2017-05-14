package CountOfSmallerNumber;

import java.util.ArrayList;

public class Solution {
    /**
     * @param A: An integer array
     * @return: The number of element in the array that
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(queries == null || queries.length == 0)
            return res;

        SegmentTreeNode root = build(-1, 10000);

        for(int n: A)
            modify(n, root);

        for(int q: queries){
            res.add(query(-1, q - 1, root));
        }

        return res;
    }

    class SegmentTreeNode{
        int start;
        int end;
        int count;
        SegmentTreeNode left;
        SegmentTreeNode right;

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

    public void modify(int target, SegmentTreeNode root){
        if(target < root.start || target > root.end)
            return;

        if(root.start == root.end && target == root.start){
            root.count += 1;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if(target <= mid)
            modify(target, root.left);
        else
            modify(target, root.right);

        root.count = root.left.count + root.right.count;
        return;
    }

    public int query(int start, int end, SegmentTreeNode root){
        if(start > end)
            return 0;

        start = Math.max(start, root.start);
        end = Math.min(end, root.end);

        if(start == root.start && end == root.end)
            return root.count;

        int mid = root.start + (root.end - root.start) / 2;
        if(end <= mid)
            return query(start, end, root.left);
        else if(start > mid)
            return query(start, end, root.right);
        else{
            int left = query(start, mid, root.left);
            int right = query(mid + 1, end, root.right);

            return left + right;
        }
    }

}

