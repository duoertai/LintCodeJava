package Rehashing;

import Common.ListNode;

public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here

        if(hashTable == null || hashTable.length == 0)
            return hashTable;

        int n = hashTable.length;
        ListNode[] res = new ListNode[2 * n];

        for(int i = 0; i < n; i++){
            if(hashTable[i] == null)
                continue;

            ListNode p1 = hashTable[i];

            while(p1 != null){
                int new_pos = (p1.val % (2 * n) + 2 * n) % (2 * n);

                if(res[new_pos] == null){
                    res[new_pos] = new ListNode(p1.val);
                }
                else{
                    ListNode p2 = res[new_pos];
                    while(p2.next != null)
                        p2 = p2.next;

                    p2.next = new ListNode(p1.val);
                }

                p1 = p1.next;
            }
        }

        return res;
    }
}

