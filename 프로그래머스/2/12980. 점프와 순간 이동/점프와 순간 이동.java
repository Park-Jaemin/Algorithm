import java.util.*;

public class Solution {
    public int solution(int n) {
        return dp(n, 0);
    }
    
    int dp(int n, int cost) {
        if (n == 1) return 1;

        if (n % 2 == 0) {
            cost += dp(n/2, 0);
        } else {
            cost += dp(n-1, 1);
        }

        return cost;
    }
}