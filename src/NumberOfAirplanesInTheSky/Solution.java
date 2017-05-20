package NumberOfAirplanesInTheSky;

import Common.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here

        if(airplanes == null || airplanes.size() == 0)
            return 0;

        int n = airplanes.size();
        Time[] times = new Time[2 * n];
        for(int i = 0; i < n; i++){
            Interval temp = airplanes.get(i);
            times[2 * i] = new Time(temp.start, true);
            times[2 * i + 1] = new Time(temp.end, false);
        }

        Arrays.sort(times, new Comparator<Time>(){
            public int compare(Time t1, Time t2){
                if(t1.time != t2.time)
                    return t1.time - t2.time;

                if(t1.takeoff && !t2.takeoff)
                    return 1;

                if(!t1.takeoff && t2.takeoff)
                    return -1;

                return 0;
            }
        });

        int res = 0;
        int count = 0;

        for(int i = 0; i < 2 * n; i++){
            if(times[i].takeoff)
                count++;
            else
                count--;

            res = Math.max(res, count);
        }

        return res;
    }

    class Time{
        public int time;
        public boolean takeoff;

        public Time(int time, boolean takeoff){
            this.time = time;
            this.takeoff = takeoff;
        }
    }
}