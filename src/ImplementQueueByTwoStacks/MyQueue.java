package ImplementQueueByTwoStacks;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        // do initialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());

        int res = stack2.pop();

        while(!stack2.isEmpty())
            stack1.push(stack2.pop());

        return res;
    }

    public int top() {
        // write your code here
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());

        int res = stack2.peek();

        while(!stack2.isEmpty())
            stack1.push(stack2.pop());

        return res;
    }
}
