import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            queue1.offer(arr1[i]);
            sum1 += arr1[i];
            
            queue2.offer(arr2[i]);
            sum2 += arr2[i];
        }
        
        while (sum1 != sum2) {
            if (answer > arr1.length*4) return -1;
            
            int poll;
            if (sum1 < sum2) {
                poll = queue2.poll();
                queue1.offer(poll);
                sum1 += poll;
                sum2 -= poll;
            } else {
                poll = queue1.poll();
                queue2.offer(poll);
                sum2 += poll;
                sum1 -= poll;
            }
            answer++;
        }
        
        return answer;
    }
}