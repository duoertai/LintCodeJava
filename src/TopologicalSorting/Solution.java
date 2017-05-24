package TopologicalSorting;

import Common.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();

        if(graph == null || graph.size() == 0)
            return res;

        HashMap<DirectedGraphNode, Integer> inDegree = new HashMap<DirectedGraphNode, Integer>();
        LinkedList<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

        for(DirectedGraphNode node: graph)
            inDegree.put(node, 0);

        for(DirectedGraphNode node: graph){
            for(DirectedGraphNode next: node.neighbors){
                inDegree.put(next, inDegree.get(next) + 1);
            }
        }

        for(DirectedGraphNode node: inDegree.keySet()){
            if(inDegree.get(node) == 0)
                queue.offer(node);
        }

        while(!queue.isEmpty()){
            DirectedGraphNode temp = queue.poll();
            res.add(temp);

            for(DirectedGraphNode next: temp.neighbors){
                inDegree.put(next, inDegree.get(next) - 1);

                if(inDegree.get(next) == 0)
                    queue.offer(next);
            }
        }

        return res;
    }
}