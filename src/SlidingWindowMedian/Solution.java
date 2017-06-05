package SlidingWindowMedian;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(nums == null || nums.length < k || k <= 0)
            return res;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });

        for(int i = 0; i < k; i++){
            if(maxHeap.size() == minHeap.size()){
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(minHeap.poll());
            }
            else{
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
            }
        }

        for(int i = k; i < nums.length; i++){
            res.add(maxHeap.peek());

            if(maxHeap.size() == minHeap.size()){
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(minHeap.poll());
            }
            else{
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
            }

            if(maxHeap.contains(nums[i - k])){
                maxHeap.remove(nums[i - k]);
                if(maxHeap.size() < minHeap.size())
                    maxHeap.offer(minHeap.poll());
            }
            else{
                minHeap.remove(nums[i - k]);
                if(maxHeap.size() == minHeap.size() + 2)
                    minHeap.offer(maxHeap.poll());
            }
        }

        res.add(maxHeap.peek());

        return res;
    }
}
