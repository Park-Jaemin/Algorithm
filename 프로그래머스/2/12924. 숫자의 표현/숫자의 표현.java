class Solution {
    public int solution(int target) {
        int answer = 0;

        for(int i = 1; i<=target; i++){
            int sum = 0;
            
            for(int j = i; j<=target; j++){
                sum += j;
                
                if (sum == target) {
                    answer++;
                    break;
                }
                if(sum > target) {
                    break;
                }
            }
        }

        return answer;
    }
}