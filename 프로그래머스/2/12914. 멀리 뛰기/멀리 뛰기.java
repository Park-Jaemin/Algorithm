class Solution {
    Long[] arr;
    public long solution(int n) {
        // DP bottom up
//         long[] arr = new long[n];
//         arr[0] = 1;
//         if (n > 1) {
//             arr[1] = 2;
//         }
        
//         for (int i = 2; i < n; i++) {
//             arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
//         }
        
//         return arr[n-1];
        arr = new Long[n+1];
        return dp(n);
    }
    
    long dp(int n) {
        if (n == 1) return arr[1] = 1L;
        if (n == 2) return arr[2] = 2L;
        
        if (arr[n] == null) {
            return arr[n] = (dp(n-2) + dp(n-1)) % 1234567;
        } else {
            return arr[n];
        }
    }
}