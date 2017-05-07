package MergeSortedArray;

class Solution {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here

        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        for(; index >= 0; index--){
            int num1 = Integer.MIN_VALUE;
            if(i >= 0)
                num1 = A[i];

            int num2 = Integer.MIN_VALUE;
            if(j >= 0)
                num2 = B[j];

            if(num1 > num2){
                A[index] = num1;
                i--;
            }
            else{
                A[index] = num2;
                j--;
            }
        }

        return;
    }
}