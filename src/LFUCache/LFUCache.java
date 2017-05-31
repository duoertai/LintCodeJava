package LFUCache;

import java.util.HashMap;

public class LFUCache {

    class Node{
        public int key;
        public int value;
        public int times;
        public Node last;
        public Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.times = 1;
            this.last = null;
            this.next = null;
        }

    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    // @param capacity, an integer
    public LFUCache(int capacity) {
        if(capacity <= 0)
            return;

        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = new Node(-1, -1);
        this.tail = head;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if(this.map.containsKey(key)){
            Node temp = this.map.get(key);
            temp.value = value;
            temp.times++;

            if(temp.last == this.head)
                return;

            while(temp.last != this.head && temp.times >= temp.last.times)
                swap(temp);
        }
        else{
            Node temp = new Node(key, value);
            this.map.put(key, temp);

            if(this.map.size() <= this.capacity){
                this.tail.next = temp;
                temp.last = this.tail;
                this.tail = temp;
            }
            else{
                this.map.remove(this.tail.key);
                this.tail = this.tail.last;
                this.tail.next = temp;
                temp.last = this.tail;
                this.tail = temp;
            }
            while(temp.last != this.head && temp.times >= temp.last.times)
                swap(temp);
        }


    }

    public int get(int key) {
        if(!this.map.containsKey(key))
            return -1;

        Node temp = this.map.get(key);
        int res = temp.value;
        temp.times++;

        if(temp.last == this.head)
            return res;

        while(temp.last != this.head && temp.times >= temp.last.times)
            swap(temp);

        return res;
    }

    public void swap(Node n){
        Node n1 = n.last.last;
        Node swap = n.last;

        if(n.next == null){
            n1.next = n;
            n.last = n1;
            n.next = swap;
            swap.last = n;
            swap.next = null;
            this.tail = swap;
        }
        else{
            Node n2 = n.next;
            n1.next = n;
            n.last = n1;
            n.next = swap;
            swap.last = n;
            swap.next = n2;
            n2.last = swap;
        }
    }
}
