package SortIntegers;

public class Solution1 {
    public void sortIntegers(int[] A) {
        // insertion sort

        if(A == null || A.length <= 1)
            return;

        for(int i = 0; i < A.length - 1; i++){
            int min = i;
            int j = i + 1;

            for(; j < A.length; j++){
                if(A[j] < A[min])
                    min = j;
            }

            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }

        return;
    }
}
