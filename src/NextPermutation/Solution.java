package NextPermutation;

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: An array of integers that's next permuation
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here

        if(nums == null || nums.length <= 1)
            return nums;

        int mark = nums.length - 1;

        while(mark > 0 && nums[mark] <= nums[mark - 1])
            mark--;

        if(mark == 0) {
            reverse(nums, 0, nums.length - 1);
            return nums;
        }

        int smallest = nums.length - 1;
        while(smallest > mark && nums[smallest] <= nums[mark - 1])
            smallest--;

        swap(nums, mark - 1, smallest);
        reverse(nums, mark, nums.length - 1);
        return nums;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end)
            swap(nums, start++, end--);

        return;
    }
}
