import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    int dfs(int[] numbers, int target, int depth, int now) {
        if (depth == numbers.length) {
            return now == target ? 1 : 0;
        }
        
        return dfs(numbers, target, depth+1, now+numbers[depth]) + dfs(numbers, target, depth+1, now-numbers[depth]);
    }
}