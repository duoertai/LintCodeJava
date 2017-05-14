package CourseScheduleII;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here

        course[] courses = new course[numCourses];
        for(int i = 0; i < numCourses; i++)
            courses[i] = new course(i);

        for(int i = 0; i < prerequisites.length; i++){
            courses[prerequisites[i][0]].in++;
            courses[prerequisites[i][1]].next.add(prerequisites[i][0]);
        }

        LinkedList<course> queue = new LinkedList<course>();

        for(int i = 0; i < numCourses; i++)
            if(courses[i].in == 0)
                queue.offer(courses[i]);

        ArrayList<Integer> res = new ArrayList<Integer>();

        while(!queue.isEmpty()){
            course temp = queue.poll();
            res.add(temp.label);

            for(int n: temp.next){
                courses[n].in--;
                if(courses[n].in == 0)
                    queue.offer(courses[n]);
            }
        }

        if(res.size() < numCourses)
            return new int[0];

        int[] order = new int[numCourses];
        for(int i = 0; i < order.length; i++)
            order[i] = res.get(i);
        return order;
    }

    class course{
        public int label;
        public int in;
        public ArrayList<Integer> next;

        public course(int label){
            this.label = label;
            this.in = 0;
            this.next = new ArrayList<Integer>();
        }
    }
}
