import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> people = new ArrayList<>();
        int[] answer = new int[n];

        long totalCaseCount = 1;
        for (int i = 1; i <= n; i++) {
            people.add(i);
            totalCaseCount *= i;
        }

        k--;
        int index = 0;
        while (index < n) {
            totalCaseCount /= n-index;
            answer[index++] = people.remove((int) (k / totalCaseCount));
            k %= totalCaseCount;
        }

        return answer;
    }
}