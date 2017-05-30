package FrogJump;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /**
     * @param stones a list of stones' positions in sorted ascending order
     * @return true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> course = new HashMap<Integer, HashSet<Integer>>();

        for(int i = 0; i < stones.length; i++)
            course.put(stones[i], new HashSet<Integer>());

        course.get(0).add(0);

        for(int i = 0; i < stones.length; i++){
            int temp = stones[i];

            for(int step: course.get(temp)){
                if(step - 1 > 0 && course.containsKey(temp + step - 1)){
                    course.get(temp + step - 1).add(step - 1);
                }

                if(step > 0 && course.containsKey(temp + step)){
                    course.get(temp + step).add(step);
                }

                if(step + 1 > 0 && course.containsKey(temp + step + 1)){
                    course.get(temp + step + 1).add(step + 1);
                }
            }
        }

        return course.get(stones[stones.length - 1]).size() != 0;
    }
}