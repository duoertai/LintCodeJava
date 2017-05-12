package Common;

import java.util.ArrayList;

/**
 * Created by ertaiduo on 5/12/17.
 */
public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
