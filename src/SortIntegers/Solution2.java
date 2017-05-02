package SortIntegers;

public class Solution2 {
    public void sortIntegers(int[] A) {
        // bubble sort
        if(A == null || A.length <= 1)
            return;

        for(int i = 0; i < A.length - 1; i++){
            for(int j = 0; j < A.length - 1 - i; j++){
                if(A[j] > A[j + 1]){
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        return;
    }
}
