package MergeTwoSortedArray;

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        if(A == null)
            return B;
        if(B == null)
            return A;

        int m = A.length;
        int n = B.length;
        int len = m + n;

        int[] res = new int[len];

        int index = 0;
        int i = 0;
        int j = 0;

        for(; index < len; index++){
            int num1 = Integer.MAX_VALUE;
            if(i < m)
                num1 = A[i];

            int num2 = Integer.MAX_VALUE;
            if(j < n)
                num2 = B[j];

            if(num1 < num2){
                res[index] = num1;
                i++;
            }
            else{
                res[index] = num2;
                j++;
            }
        }

        return res;
    }
}