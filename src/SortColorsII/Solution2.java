package SortColorsII;

/**
 * Created by ertaiduo on 5/22/17.
 */
public class Solution2 {
    public void sortColors2(int[] colors, int k) {
        if(colors == null || colors.length == 0)
            return;

        int left = 0;
        int i = 0;
        int right = colors.length - 1;
        int smallest = 1;
        int largest = k;

        while(smallest < largest){
            while(i <= right){
                if(colors[i] == smallest)
                    swap(colors, i++, left++);
                else if(colors[i] == largest)
                    swap(colors, i, right--);
                else
                    i++;
            }
            i = left;
            smallest++;
            largest--;
        }

        return;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
