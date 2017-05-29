package DataStreamMedian;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return nums;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2){
                return n2 - n1;
            }
        });

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(maxHeap.size() == minHeap.size()){
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(minHeap.poll());
            }
            else{
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
            }

            res[i] = maxHeap.peek();
        }

        return res;
    }
}