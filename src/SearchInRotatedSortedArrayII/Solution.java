package SearchInRotatedSortedArrayII;

public class Solution {
    /**
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean
     */
    public boolean search(int[] A, int target) {
        // write your code here

        if(A == null || A.length == 0)
            return false;

        if(A[0] < A[A.length - 1])
            return binarySearch(A, 0, A.length - 1, target);

        return search(A, 0, A.length - 1, target);
    }

    public boolean search(int[] nums, int left, int right, int target){
        if(left > right)
            return false;

        if(left == right && nums[left] == target)
            return true;

        if(nums[left] < nums[right])
            return binarySearch(nums, left, right, target);

        int mid = left + (right - left) / 2;

        if(nums[left] == nums[mid]){
            return search(nums, left + 1, right, target);
        }
        else if(nums[left] < nums[mid]){
            if(target < nums[left] || target > nums[mid])
                return search(nums, mid + 1, right, target);
            else
                return binarySearch(nums, left, mid, target);
        }
        else{
            if(target < nums[mid] || target > nums[right])
                return search(nums, left, mid - 1, target);
            else
                return binarySearch(nums, mid, right, target);
        }
    }

    public boolean binarySearch(int[] nums, int left, int right, int target){
        if(left > right)
            return false;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target)
                return true;

            if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return nums[left] == target;
    }
}
