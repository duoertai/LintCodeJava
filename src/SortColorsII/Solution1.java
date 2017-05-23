package SortColorsII;

/**
 * Created by ertaiduo on 5/22/17.
 */
public class Solution1 {
    public void sortColors2(int[] colors, int k) {
        // write your code here

        if(colors == null || colors.length == 0)
            return;

        sort(colors, 0, colors.length - 1, 1, k);
        return;
    }

    public void sort(int[] nums, int start, int end, int c_start, int c_end){
        if(start > end || c_start >= c_end)
            return;

        int left = start;
        int i = start;
        int right = end;

        int c_mid = c_start + (c_end - c_start) / 2;

        while(i <= right){
            if(nums[i] == c_mid)
                i++;
            else if(nums[i] < c_mid)
                swap(nums, i++, left++);
            else
                swap(nums, i, right--);
        }

        sort(nums, start, left - 1, c_start, c_mid - 1);
        sort(nums, right + 1, end, c_mid + 1, c_end);

        return;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
