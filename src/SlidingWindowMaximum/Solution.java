package SlidingWindowMaximum;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length)
            return res;

        LinkedList<Integer> queue = new LinkedList<Integer>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];

            while(!queue.isEmpty() && num > queue.peekFirst())
                queue.pollFirst();

            queue.offerFirst(num);

            if(i >= k && queue.peekLast() == nums[i - k])
                queue.pollLast();

            if(i >= k - 1)
                res.add(queue.peekLast());
        }

        return res;
    }
}

