import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] input = new int[1_000_001];
        int[] output = new int[1_000_001];
        
        int limit = 0;
        for (int[] edge : edges) {
            int out = edge[0];
            int in = edge[1];
            output[out]++;
            input[in]++;
            
            limit = Math.max(limit, Math.max(out, in));
        }

        int[] answer = new int[4];
        for (int i = 1; i <= limit; i++) {
            if (input[i] == 0 && output[i] >= 2) {
                answer[0] = i;
            } else if (output[i] == 0) {
                answer[2]++;
            } else if (input[i] >= 2 && output[i] == 2) {
                answer[3]++;
            }
        }
        answer[1] = output[answer[0]] - answer[2] - answer[3];

        return answer;
    }
}