package SortIntegersII;

/**
 * Created by ertaiduo on 5/9/17.
 */
public class QuickSort {
    public void sortIntegers2(int[] A) {
        // Write your code here
        if(A == null || A.length <= 1)
            return;

        quicksort(A, 0, A.length - 1);
        return;
    }

    public void quicksort(int[] nums, int start, int end){
        if(start >= end)
            return;

        int left = start;
        int i = start;
        int right = end;
        int pivot = nums[end];

        while(i <= right){
            if(nums[i] < pivot)
                swap(nums, i++, left++);
            else if(nums[i] == pivot)
                i++;
            else
                swap(nums, i, right--);
        }

        quicksort(nums, start, left - 1);
        quicksort(nums, right + 1, end);
        return;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return;
    }
}
