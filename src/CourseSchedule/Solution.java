package CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Write your code here

        if(numCourses <= 1)
            return true;

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

        ArrayList<course> res = new ArrayList<course>();

        while(!queue.isEmpty()){
            course temp = queue.poll();
            res.add(temp);

            for(int n: temp.next){
                courses[n].in--;
                if(courses[n].in == 0)
                    queue.offer(courses[n]);
            }
        }

        return res.size() == numCourses;
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
