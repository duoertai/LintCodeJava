package TwoSumInputArrayIsSorted;

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here

        int[] res = new int[2];

        if(nums == null || nums.length < 2)
            return res;

        for(int i = 0; i < nums.length - 1; i++){
            int index = search(nums, i + 1, target - nums[i]);
            if(index != -1){
                res[0] = i + 1;
                res[1] = index + 1;
                break;
            }
        }

        return res;
    }

    public int search(int[] nums, int start, int target){
        if(target < nums[start] || target > nums[nums.length - 1])
            return -1;

        int left = start;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target)
                return mid;

            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return nums[left] == target ? left : -1;
    }

}