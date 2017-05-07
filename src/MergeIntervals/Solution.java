package MergeIntervals;

import Common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here

        if(intervals == null || intervals.size() <= 1)
            return intervals;

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });

        List<Interval>res = new ArrayList<Interval>();

        Interval temp = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start > temp.end){
                res.add(temp);
                temp = intervals.get(i);
            }
            else{
                temp.end = Math.max(temp.end, intervals.get(i).end);
            }
        }

        res.add(temp);

        return res;
    }

}