package SearchInRotatedSortedArray;

public class Solution {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0)
            return -1;

        if(A[0] < A[A.length - 1])
            return binarySearch(A, 0, A.length - 1, target);

        return search(A, 0, A.length - 1, target);
    }

    public int search(int[] nums, int left, int right, int target){
        if(left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if(nums[left] < nums[mid]){
            if(target < nums[left] || target > nums[mid]){
                return search(nums, mid + 1, right, target);
            }
            else{
                return binarySearch(nums, left, mid, target);
            }
        }
        else{
            if(target < nums[mid] || target > nums[right]){
                return search(nums, left, mid - 1, target);
            }
            else{
                return binarySearch(nums, mid, right, target);
            }
        }
    }

    public int binarySearch(int[] nums, int start, int end, int target){
        if(start > end)
            return -1;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
                return mid;

            if(nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        if(nums[start] == target)
            return start;
        else
            return -1;
    }

}
