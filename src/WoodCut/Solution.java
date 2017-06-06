package WoodCut;

public class Solution {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        if(L == null || L.length == 0)
            return 0;

        long sum = L[0];
        int shortest = L[0];

        for(int i = 1; i < L.length; i++){
            sum += L[i];
            shortest = Math.max(shortest, L[i]);
        }

        if(sum < k)
            return 0;
        if(shortest < 1)
            return 0;

        int left = 1;
        int right = shortest;

        while(left < right - 1){
            int mid = left + (right - left) / 2;

            if(valid(L, k, mid))
                left = mid;
            else
                right = mid;
        }

        if(valid(L, k, right))
            return right;
        else
            return left;
    }

    public boolean valid(int[] L, int k, int len){
        long sum = 0;

        for(int i = 0; i < L.length; i++){
            sum += L[i] / len;
        }

        return sum >= k;
    }

}
