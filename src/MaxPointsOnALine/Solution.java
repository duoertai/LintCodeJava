package MaxPointsOnALine;

import Common.Point;

import java.util.HashMap;

public class Solution {
    public int maxPoints(Point[] points) {
        // Write your code here

        if(points == null || points.length == 0)
            return 0;

        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int res = 1;

        for(int i = 0; i < points.length; i++){
            int duplicate = 1;
            int vertical = 0;

            for(int j = i + 1; j < points.length; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    duplicate++;
                }
                else if(points[i].x == points[j].x){
                    vertical++;
                }
                else{
                    double slope = 1.0 * (points[j].y - points[i].y) / (points[j].x - points[i].x);

                    if(!map.containsKey(slope)){
                        map.put(slope, 1);
                    }
                    else{
                        map.put(slope, map.get(slope) + 1);
                    }
                }
            }

            int max = 0;

            for(Double key: map.keySet()){
                if(map.get(key) > max){
                    max = map.get(key);
                }
            }

            res = Math.max(res, max + duplicate);
            res = Math.max(res, vertical + duplicate);

            map.clear();
        }

        return res;
    }
}