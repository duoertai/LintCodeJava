package IntervalSumII;

public class Solution {
    /* you may need to use some attributes here */
    class SegmentTreeNode{
        public int start;
        public int end;
        public long sum;
        public SegmentTreeNode left;
        public SegmentTreeNode right;

        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }

    private SegmentTreeNode root;

    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
        // write your code here
        if(A == null || A.length == 0)
            return;

        this.root = build(0, A.length - 1);
        for(int i = 0; i < A.length; i++)
            modify(i, A[i]);

        return;
    }

    public SegmentTreeNode build(int start, int end){
        if(start > end)
            return null;

        if(start == end)
            return new SegmentTreeNode(start, end);

        SegmentTreeNode r = new SegmentTreeNode(start, end);
        int mid = start + (end - start) / 2;
        SegmentTreeNode left = build(start, mid);
        SegmentTreeNode right = build(mid + 1, end);
        r.left = left;
        r.right = right;

        return r;
    }

    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return query(root, start, end);
    }

    public long query(SegmentTreeNode temp, int start, int end){
        if(start > temp.end || end < temp.start)
            return 0;

        if(temp.start == start && temp.end == end)
            return temp.sum;

        start = Math.max(start, temp.start);
        end = Math.min(end, temp.end);

        int mid = temp.start + (temp.end - temp.start) / 2;

        if(end <= mid)
            return query(temp.left, start, end);
        else if(start > mid)
            return query(temp.right, start, end);
        else{
            long left = query(temp.left, start, mid);
            long right = query(temp.right, mid + 1, end);
            return left + right;
        }
    }

    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        modify(root, index, value);
    }

    public void modify(SegmentTreeNode temp, int index, int value){
        if(index < temp.start || index > temp.end)
            return;

        if(temp.start == temp.end && temp.start == index){
            temp.sum = value;
            return;
        }

        int mid = temp.start + (temp.end - temp.start) / 2;

        if(index <= mid)
            modify(temp.left, index, value);
        else
            modify(temp.right, index, value);

        temp.sum = temp.left.sum + temp.right.sum;
        return;
    }
}
