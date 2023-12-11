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
        
//         int answer = 0;

//         for (int i = 1; i <= target; i++) {
//             answer += calc(i, target, 0, 0);   
//         }

//         return answer;
//     }
    
//        int calc(int now, int target, int sum, int count) {
//         sum += now;

//         if (sum > target) {
//             return count;
//         }

//         if (sum == target) {
//             count++;
//         }

//         count = calc(now+1, target, sum, count);
//         return count;
    }
}