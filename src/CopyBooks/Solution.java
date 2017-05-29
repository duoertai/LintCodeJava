package CopyBooks;

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if(pages == null || pages.length == 0)
            return 0;

        if(k <= 0)
            return 0;

        int sum = 0;
        for(int n: pages)
            sum += n;

        int average = sum / pages.length;

        return search(pages, k, average, sum);
    }

    public int search(int[] pages, int k, int start, int end){
        if(!valid(pages, k, end))
            return end + 1;

        while(start < end - 1){
            int mid = start + (end - start) / 2;

            if(valid(pages, k, mid))
                end = mid;
            else
                start = mid;
        }

        if(valid(pages, k, start))
            return start;
        else
            return end;
    }

    public boolean valid(int[] pages, int k, int time){
        int sum = 0;
        int people = 1;

        for(int i = 0; i < pages.length; i++){
            if(pages[i] > time)
                return false;

            if(sum + pages[i] <= time){
                sum += pages[i];
            }
            else{
                people++;
                sum = pages[i];
            }
        }

        return people <= k;
    }
}
