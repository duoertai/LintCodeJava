package InsertInterval;

import Common.Interval;

import java.util.ArrayList;

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        // write your code here

        if(intervals == null || intervals.size() == 0){
            result.add(newInterval);
            return result;
        }

        int i = 0;

        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            result.add(intervals.get(i));
            i++;
        }

        if(i == intervals.size()){
            result.add(newInterval);
            return result;
        }

        newInterval.start = Math.min(newInterval.start, intervals.get(i).start);

        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            i++;
        }

        if(i > 0)
            newInterval.end = Math.max(newInterval.end, intervals.get(i - 1).end);
        result.add(newInterval);

        while(i < intervals.size()){
            result.add(intervals.get(i));
            i++;
        }

        return result;
    }
}