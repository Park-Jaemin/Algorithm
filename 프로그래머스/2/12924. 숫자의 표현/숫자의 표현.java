class Solution {
    public int solution(int target) {
        int answer = 0;
        
        for (int i = 1; i <= target; i++) {
            answer += calc(i, target, 0, 0);   
        }
        
        return answer;
    }
    
    int calc(int now, int target, int sum, int count) {
        sum += now;
        
        if (sum > target) {
            return count;
        }
        
        if (sum == target) {
            count++;
        }
        
        count = calc(now+1, target, sum, count);
        return count;
    }
}