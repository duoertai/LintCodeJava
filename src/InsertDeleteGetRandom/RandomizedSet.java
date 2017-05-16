package InsertDeleteGetRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    private ArrayList<Integer> lst;
    private HashMap<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        // do initialize if necessary
        this.lst = new ArrayList<Integer>();
        this.map = new HashMap<Integer, Integer>();
        this.random = new Random();
    }

    // Inserts a value to the set
    // Returns true if the set did not already contain the specified element or false
    public boolean insert(int val) {
        // Write your code here
        if(map.containsKey(val))
            return false;

        int index = this.lst.size();
        map.put(val, index);
        lst.add(val);

        return true;
    }

    // Removes a value from the set
    // Return true if the set contained the specified element or false
    public boolean remove(int val) {
        // Write your code here
        if(!this.map.containsKey(val))
            return false;

        int index = this.map.get(val);
        if(index != this.lst.size() - 1){
            this.lst.set(index, this.lst.get(lst.size() - 1));
            this.map.remove(val);
            this.lst.remove(this.lst.size() - 1);
            this.map.put(this.lst.get(index), index);
        }
        else{
            this.map.remove(this.lst.get(this.lst.size() - 1));
            this.lst.remove(this.lst.size() - 1);
        }
        return true;
    }

    // Get a random element from the set
    public int getRandom() {
        // Write your code here
        return this.lst.get(this.random.nextInt(this.lst.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */
