package MajorityNumberIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.size(); i++){
            int temp = nums.get(i);

            if(map.containsKey(temp)){
                map.put(temp, map.get(temp) + 1);
            }
            else{
                if(map.size() < k - 1){
                    map.put(temp, 1);
                }
                else{
                    Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

                    while(it.hasNext()){
                        Map.Entry<Integer, Integer> entry = it.next();
                        if(entry.getValue() > 1){
                            entry.setValue(entry.getValue() - 1);
                        }
                        else{
                            it.remove();
                        }
                    }
                }
            }
        }

        int max = 0;
        int res = 0;

        for(Integer key: map.keySet()){
            int count = 0;
            for(int i = 0; i < nums.size(); i++){
                if(key.equals(nums.get(i)))
                    count = count + 1;
            }

            if(count > max){
                max = count;
                res = key;
            }

        }

        return res;
    }
}

