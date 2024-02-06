import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int limit = sequence.length;
        int[] answer = {0, limit};

        int front = 0;
        int back = 0;
        int sum = 0;
        
        do {
            if (sum <= k) {
                if (back == limit) break ;
                sum += sequence[back++];
            } else {
                sum -= sequence[front++];
            }
            
            if (sum == k && answer[1] - answer[0] > (back - 1) - front) {
                answer = new int[]{front, (back - 1)};
            }
        } while (front < back);

        return answer;
    }
}