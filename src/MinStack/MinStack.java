package MinStack;

import java.util.Stack;

public class MinStack {
    class node{
        public int val;
        public int min;

        public node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }

    Stack<node> stack;

    public MinStack() {
        // do initialize if necessary
        this.stack = new Stack<node>();
    }

    public void push(int number) {
        // write your code here
        if(this.stack.isEmpty())
            stack.push(new node(number, number));
        else
            stack.push(new node(number, Math.min(number, stack.peek().min)));
    }

    public int pop() {
        // write your code here
        return stack.pop().val;
    }

    public int min() {
        // write your code here
        return stack.peek().min;
    }
}

