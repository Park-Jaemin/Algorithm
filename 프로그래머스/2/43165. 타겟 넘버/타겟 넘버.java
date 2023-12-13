import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    int dfs(int[] numbers, int target, int now, int depth) {
        if (depth == numbers.length) return now == target ? 1 : 0;
        
        return dfs(numbers, target, now+numbers[depth], depth+1) + dfs(numbers, target, now-numbers[depth], depth+1);
    }
}