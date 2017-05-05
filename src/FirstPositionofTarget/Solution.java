package FirstPositionofTarget;

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
            return -1;

        int left = 0;
        int right = nums.length - 1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;

            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                right = mid;
        }

        if(nums[left] == target)
            return left;
        else if(nums[right] == target)
            return right;
        else
            return -1;
    }
}
