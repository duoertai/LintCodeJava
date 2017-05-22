package RouteBetweenTwoNodesInGraph;

import Common.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        HashSet<DirectedGraphNode> set = new HashSet<DirectedGraphNode>();
        LinkedList<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

        queue.offer(s);

        while(!queue.isEmpty()){
            DirectedGraphNode temp = queue.poll();
            if(temp == t)
                return true;

            for(DirectedGraphNode next: temp.neighbors){

                if(!set.contains(next)){
                    set.add(next);
                    queue.offer(next);
                }
            }
        }

        return false;
    }
}
