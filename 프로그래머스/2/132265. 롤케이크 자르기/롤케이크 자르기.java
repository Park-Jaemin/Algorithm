import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int[] left = new int[10001];
        int[] right = new int[10001];
        int rightTypeCount = 0;
        
        for (int type : topping) {
            if (right[type] == 0) {
                rightTypeCount++;
            }
            right[type]++;
        }

        int answer = 0;
        int leftTypeCount = 0;
        for (int type : topping) {
            if (right[type] == 1) {
                rightTypeCount--;
            }

            if (left[type] == 0) {
                leftTypeCount++;
            }
            right[type]--;
            left[type]++;

            if (leftTypeCount == rightTypeCount) {
                answer++;
            }
        }
        return answer;
    }
}