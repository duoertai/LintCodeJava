package CosineSimilarity;

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        if(A == null || A.length == 0 || B == null || B.length == 0 || A.length != B.length)
            return 2.0;

        long a = 0;
        for(int i = 0; i < A.length; i++){
            a += A[i] * A[i];
        }

        if(a == 0)
            return 2.0;

        long b = 0;
        for(int i = 0; i < B.length; i++){
            b += B[i] * B[i];
        }

        long num = 0;
        for(int i = 0; i < A.length; i++){
            num += A[i] * B[i];
        }

        if(b == 0)
            return 2.0;

        return num * 1.0 / (Math.sqrt(a * b) * 1.0);
    }
}
