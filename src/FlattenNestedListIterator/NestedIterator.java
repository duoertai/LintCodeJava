package FlattenNestedListIterator;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import Common.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        this.stack = new Stack<NestedInteger>();
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }

        while(!stack.isEmpty() && !stack.peek().isInteger()){
            List<NestedInteger> lst = stack.pop().getList();
            for(int i = lst.size() - 1; i >= 0; i--)
                stack.push(lst.get(i));
        }

    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        int res = stack.pop().getInteger();

        while(!stack.isEmpty() && !stack.peek().isInteger()){
            List<NestedInteger> lst = stack.pop().getList();
            for(int i = lst.size() - 1; i >= 0; i--)
                stack.push(lst.get(i));
        }

        return res;
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        return !stack.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */