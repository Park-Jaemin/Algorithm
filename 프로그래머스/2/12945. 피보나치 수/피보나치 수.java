class Solution {
//     public int solution(int n) {
//         return fibonacci(n) % 1234567;
//     }
    
//     int fibonacci(int n) {
//         if (n == 0) return 0;
//         if (n == 1) return 1;
//         return (fibonacci(n-2) + fibonacci(n-1)) % 1234567;
//     }
    
    public long solution(int n) {
        long[] arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;
        
        for (int i = 2; i < n+1; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
        }
        return arr[n];
    }
}