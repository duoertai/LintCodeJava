package MergeKSortedLists;

import Common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here

        if(lists == null || lists.size() == 0)
            return null;

        int n = lists.size();
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(n, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        ListNode fakehead = new ListNode(0);
        ListNode p = fakehead;

        for(int i = 0; i < n; i++)
            if(lists.get(i) != null)
                heap.offer(lists.get(i));

        while(heap.size() != 0){
            ListNode temp = heap.poll();
            if(temp.next != null)
                heap.offer(temp.next);

            p.next = temp;
            p = p.next;
        }

        p.next = null;

        return fakehead.next;
    }
}

