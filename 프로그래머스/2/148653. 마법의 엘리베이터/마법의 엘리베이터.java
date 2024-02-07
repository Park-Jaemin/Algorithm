class Solution {
    public int solution(int storey) {
        return find(storey, 0);
    }
    
    int find(int storey, int answer) {
        if (storey == 0) {
            return answer;
        }
        
        int digit = storey % 10;
        storey /= 10;
        
        if (digit > 5) {
            answer += (10 - digit);
            storey++;
        } else if (digit < 5) {
            answer += digit;
        } else {
            if (storey % 10 >= 5) {
                answer += (10 - digit);
                storey++;
            } else {
                answer += digit;
            }
        }
        
        return find(storey, answer);
    }
}