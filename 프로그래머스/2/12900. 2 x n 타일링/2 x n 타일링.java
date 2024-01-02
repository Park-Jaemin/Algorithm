class Solution {
    public int solution(int n) {
        return find(n, new int[n+1]);
    }
    
    int find(int n, int[] dp) {
        if (n == 1) return dp[1] = 1;
        if (n == 2) return dp[2] = 2;
        
        if (dp[n] == 0) {
            return dp[n] = (find(n-2, dp) + find(n-1, dp)) % 1_000_000_007;
        } else {
            return dp[n];
        }
    }
}