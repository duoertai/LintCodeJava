package WiggleSort;

public class Solution2 {
    public void wiggleSort(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0)
            return;

        int len = nums.length;

        if(len % 2 == 0)
            partition(nums, 0, len - 1, len / 2 - 1);
        else
            partition(nums, 0, len - 1, len / 2);

        int[] temp = new int[len];

        int left = len % 2 == 0 ? len / 2 - 1 : len / 2;
        int right = len - 1;
        int mark = left;
        int i = 0;

        while(right > mark){
            temp[i] = nums[left--];
            temp[i + 1] = nums[right--];
            i += 2;
        }

        if(len % 2 == 1)
            temp[len - 1] = nums[0];

        for(int j = 0; j < len; j++)
            nums[j] = temp[j];

        return;
    }

    public void partition(int[] nums, int start, int end, int k){
        if(start > end)
            return;

        int left = start;
        int i = start;
        int right = end;
        int pivot = nums[end];

        while(i <= right){
            if(nums[i] < pivot)
                swap(nums, i++, left++);
            else if(nums[i] > pivot)
                swap(nums, i, right--);
            else
                i++;
        }

        if(k >= left && k <= right)
            return;

        if(k < left)
            partition(nums, start, left - 1, k);
        else
            partition(nums, right + 1, end, k);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return;
    }
}
