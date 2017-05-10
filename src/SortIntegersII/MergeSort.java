package SortIntegersII;

/**
 * Created by ertaiduo on 5/9/17.
 */
public class MergeSort {
    public void sortIntegers2(int[] A) {
        // Write your code here
        if(A == null || A.length <= 1)
            return;

        mergesort(A, 0, A.length - 1);
        return;
    }

    public void mergesort(int[] nums, int start, int end){
        if(start >= end)
            return;

        int mid = start + (end - start) / 2;

        mergesort(nums, start, mid);
        mergesort(nums, mid + 1, end);
        merge(nums, start, mid, end);
        return;
    }

    public void merge(int[] nums, int start, int mid, int end){
        int[] part1 = new int[mid - start + 1];
        int[] part2 = new int[end - mid];

        for(int i = 0; i < mid - start + 1; i++)
            part1[i] = nums[start + i];
        for(int i = 0; i < end - mid; i++)
            part2[i] = nums[mid + 1 + i];

        int p1 = 0;
        int p2 = 0;
        int i = start;

        while(p1 < part1.length || p2 < part2.length){
            int num1 = Integer.MAX_VALUE;
            if(p1 < part1.length)
                num1 = part1[p1];

            int num2 = Integer.MAX_VALUE;
            if(p2 < part2.length)
                num2 = part2[p2];

            if(num1 < num2){
                nums[i++] = num1;
                p1++;
            }
            else{
                nums[i++] = num2;
                p2++;
            }

        }

        return;
    }

}
