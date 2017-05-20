package NutsAndBoltsProblem;

import Common.NBComparator;

/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
 */
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        sort(nuts, 0, nuts.length - 1, bolts, 0, bolts.length - 1, compare);
        return;
    }

    public void sort(String[] nuts, int n_start, int n_end, String[] bolts, int b_start, int b_end, NBComparator compare){
        if(n_start >= n_end || b_start >= b_end)
            return;

        int index = partition(nuts, n_start, n_end, bolts[b_end], compare);

        partition(bolts, b_start, b_end, nuts[index], compare);

        sort(nuts, n_start, index - 1, bolts, b_start, index - 1, compare);
        sort(nuts, index + 1, n_end, bolts, index + 1, b_end, compare);

        return;
    }

    public int partition(String[] strs, int start, int end, String pivot, NBComparator compare){
        int left = start;
        int i = start;
        int right = end;

        while(i <= right){
            if(compare.cmp(strs[i], pivot) == -1 || compare.cmp(pivot, strs[i]) == 1)
                swap(strs, i++, left++);
            else if(compare.cmp(strs[i], pivot) == 1 || compare.cmp(pivot, strs[i]) == -1)
                swap(strs, i, right--);
            else
                i++;
        }

        return left;
    }

    public void swap(String[] strs, int i, int j){
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;

        return;
    }
}