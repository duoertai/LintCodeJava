package WordLadderII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();

        if(start == null || start.length() == 0 || end == null || end.length() == 0 || dict == null || dict.size() == 0 || start.length() != end.length())
            return res;

        dict.remove(start);
        dict.add(end);

        LinkedList<Node> curr = new LinkedList<Node>();
        LinkedList<Node> next = new LinkedList<Node>();
        ArrayList<Node> list = new ArrayList<Node>();
        curr.offer(new Node(start, null));

        while(!curr.isEmpty()){
            Node temp = curr.poll();
            dict.remove(temp.s);

            char[] array = temp.s.toCharArray();

            for(int i = 0; i < array.length; i++){
                char original = array[i];

                for(char c = 'a'; c <= 'z'; c++){
                    if(c == original)
                        continue;

                    array[i] = c;
                    String next_str = String.valueOf(array);
                    if(next_str.equals(end)){
                        list.add(new Node(next_str, temp));
                    }
                    else if(dict.contains(next_str)){
                        next.offer(new Node(next_str, temp));
                    }
                }

                array[i] = original;
            }

            if(curr.isEmpty()){
                if(list.size() > 0)
                    break;

                curr = next;
                next = new LinkedList<Node>();
            }
        }

        for(Node n: list){
            List<String> solution = new ArrayList<String>();

            while(n != null){
                solution.add(0, n.s);
                n = n.last;
            }

            res.add(solution);
        }

        return res;
    }

    class Node{
        public Node last;
        public String s;

        public Node(String s, Node last){
            this.s = s;
            this.last = last;
        }
    }

}