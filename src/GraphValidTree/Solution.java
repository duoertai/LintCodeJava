package GraphValidTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if(n <= 0)
            return false;

        if(edges == null)
            return false;

        if(edges.length != n - 1)
            return false;

        node[] nodes = new node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new node(i);
        }

        for(int i = 0; i < edges.length; i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            nodes[n1].next.add(nodes[n2]);
            nodes[n2].next.add(nodes[n1]);
        }

        LinkedList<node> queue = new LinkedList<node>();
        HashSet<node> set = new HashSet<node>();

        queue.offer(nodes[0]);

        while(!queue.isEmpty()){
            node temp = queue.poll();
            set.add(temp);
            for(node neighbor: temp.next){
                neighbor.next.remove(temp);

                if(set.contains(neighbor))
                    return false;

                queue.offer(neighbor);
            }
        }

        return set.size() == n;
    }

    class node{
        public int label;
        public ArrayList<node> next;

        public node(int label){
            this.label = label;
            this.next = new ArrayList<node>();
        }
    }

}