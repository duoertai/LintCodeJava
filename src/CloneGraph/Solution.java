package CloneGraph;
import Common.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null)
            return null;

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);

        while(!queue.isEmpty()){
            UndirectedGraphNode temp = queue.poll();
            map.put(temp, new UndirectedGraphNode(temp.label));

            for(UndirectedGraphNode next: temp.neighbors){
                if(!map.containsKey(next)){
                    queue.offer(next);
                }
            }
        }

        for(UndirectedGraphNode n: map.keySet()){
            for(UndirectedGraphNode neighbor: n.neighbors){
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}