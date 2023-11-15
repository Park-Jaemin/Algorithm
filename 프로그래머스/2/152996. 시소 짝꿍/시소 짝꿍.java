import java.util.*;

/*
    1. 오름차순 정렬
    2. n번 요소 시작, n+1 요소부터 비교
    3. n+m 요소가 n*4 초과일 경우, 다음 요소로 넘기기
*/

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);

        long pre = 0; 
        // 현재 무게가 이전 무게와 동일할 경우 계산하지 않고 1개만 줄이고 전체 갯수에 합산 후, for 연산을 건너뛰기 위한 변수
        for (int i = 0; i < weights.length-1; i++) {
            if (i > 0 && weights[i] == weights[i-1]) {
                pre--;
                answer += pre;
                continue;
            }

            pre = 0;
            for (int j = i+1; j < weights.length; j++) {
                if (weights[i]*4 < weights[j]) break;

                if (weights[i] == weights[j]
                    || weights[i]*3 == weights[j]*2
                    || weights[i]*4 == weights[j]*2
                    || weights[i]*4 == weights[j]*3) pre++;
            }
            answer += pre;
        }
        return answer;
    }
}