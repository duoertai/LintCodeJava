package InterleavingPositiveAndNegativeNumbers;
class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        // write your code here
        if(A == null || A.length <= 2)
            return;

        int left = 0;
        int i = 0;
        int right = A.length - 1;

        while(i <= right){
            if(A[i] == 0)
                i++;
            else if(A[i] > 0)
                swap(A, i++, left++);
            else
                swap(A, i, right--);
        }

        if(A.length % 2 == 0){
            left = 0;
            right = A.length - 1;

            while(left < right){
                swap(A, left, right);
                left += 2;
                right -= 2;
            }
            return;
        }
        else{
            if(A[A.length / 2] > 0){
                left = 1;
                right = A.length - 1;
            }
            else{
                left = 0;
                right = A.length - 2;
            }
            while(left < right){
                swap(A, left, right);
                left += 2;
                right -= 2;
            }
            return;
        }

    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

}