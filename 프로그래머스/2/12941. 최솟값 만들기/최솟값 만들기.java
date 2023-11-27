import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int length = A.length;
        
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += A[i] * B[length-i-1];
        }
        
        return sum;
    }
}