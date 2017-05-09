package RemoveElement;

public class Solution {
    /**
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if(A == null || A.length == 0)
            return 0;

        if(A.length == 1)
            return A[0] == elem ? 0 : 1;

        int left = 0;
        int i = 0;
        int right = A.length - 1;

        while(i < right){
            if(A[i] == elem)
                swap(A, i, right--);
            else
                i++;
        }

        return A[right] == elem ? right : right + 1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return;
    }
}

