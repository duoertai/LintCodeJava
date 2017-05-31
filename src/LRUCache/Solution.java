package LRUCache;

import java.util.HashMap;

public class Solution {
    class Node{
        public int key;
        public int value;
        public Node last;
        public Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.last = null;
            this.next = null;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    // @param capacity, an integer
    public Solution(int capacity) {
        if(capacity <= 0)
            return;

        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = head;
        this.map = new HashMap<Integer, Node>();
    }

    // @return an integer
    public int get(int key) {
        if(!this.map.containsKey(key))
            return -1;

        Node temp = this.map.get(key);
        int res = temp.value;

        if(temp.next == null){
            temp.last.next = null;
            this.tail = temp.last;
            temp.last = null;
        }
        else{
            temp.last.next = temp.next;
            temp.next.last = temp.last;
            temp.next = null;
            temp.last = null;
        }

        moveToHead(temp);
        return res;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if(this.map.containsKey(key)){
            Node temp = this.map.get(key);
            temp.value = value;

            if(temp.next == null){
                temp.last.next = null;
                this.tail = temp.last;
                temp.last = null;
            }
            else{
                temp.last.next = temp.next;
                temp.next.last = temp.last;
                temp.next = null;
                temp.last = null;
            }

            moveToHead(temp);
        }
        else{
            Node temp = new Node(key, value);
            this.map.put(key, temp);

            if(this.map.size() == 1){
                this.head.next = temp;
                temp.last = this.head;
                this.tail = temp;
            }
            else if(this.map.size() <= this.capacity){
                moveToHead(temp);
            }
            else{
                this.map.remove(this.tail.key);
                this.tail = this.tail.last;
                this.tail.next = null;
                moveToHead(temp);
            }
        }

    }

    public void moveToHead(Node n){
        n.next = this.head.next;
        n.last = this.head;
        if(n.next != null)
            n.next.last = n;
        n.last.next = n;

        if(this.tail == this.head)
            this.tail = n;

        return;
    }

}
