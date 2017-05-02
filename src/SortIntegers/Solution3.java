package SortIntegers;

public class Solution3 {
    public void sortIntegers(int[] A) {
        // insertion sort

        if(A == null || A.length <= 1)
            return;

        for(int i = 1; i <= A.length - 1; i++){
            int temp = A[i];
            int j = i - 1;

            while(j >= 0){
                if(A[j] >= temp){
                    A[j + 1] = A[j];
                    j--;
                }
                else{
                    break;
                }
            }

            A[j + 1] = temp;
        }

        return;
    }
}
