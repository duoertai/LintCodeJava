package SubarraySumClosest;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        if(nums == null || nums.length == 0)
            return res;

        if(nums.length == 1){
            res[0] = 0;
            res[1] = 0;
            return res;
        }

        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];

        for(int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + nums[i];

        node[] nodes = new node[n];
        for(int i = 0; i < n; i++)
            nodes[i] = new node(sum[i], i);

        Arrays.sort(nodes, new Comparator<node>(){
            public int compare(node n1, node n2){
                return n1.val - n2.val;
            }
        });

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            if(min > nodes[i + 1].val - nodes[i].val){
                min = nodes[i + 1].val - nodes[i].val;
                res[0] = Math.min(nodes[i].index, nodes[i + 1].index) + 1;
                res[1] = Math.max(nodes[i].index, nodes[i + 1].index);
            }
        }

        return res;
    }

    class node{
        public int val;
        public int index;

        public node(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

}

