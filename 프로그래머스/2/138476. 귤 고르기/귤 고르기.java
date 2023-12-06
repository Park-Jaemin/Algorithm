import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Arrays.sort(tangerine);
        int limit = tangerine.length;
        int[] count = new int[tangerine[limit-1]+1];

        for (int i = 0; i < limit; i++) {
            count[tangerine[i]-1]++;
        }

        Arrays.sort(count);
        int sum = 0;
        for (int i = count.length-1; i >= 0 && sum < k; i--) {
            sum += count[i];
            answer++;
        }

        return answer;
    }
}