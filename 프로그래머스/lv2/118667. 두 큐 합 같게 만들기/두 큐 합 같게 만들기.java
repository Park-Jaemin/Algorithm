import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;

        for (int num : queue1) {
            q1.offer(num);
            sum1 += num;
        }
        for (int num : queue2) {
            q2.offer(num);
            sum2 += num;
        }

        int limit = q1.size() * 4;
        int count = 0;
        while (sum1 != sum2) {
            int poll;

            if (count > limit) {
                return -1;
            }
            
            if (sum1 > sum2) {
                poll = q1.poll();
                q2.offer(poll);
                sum1 -= poll;
                sum2 += poll;
                count++;
            } else if (sum2 > sum1) {
                poll = q2.poll();
                q1.offer(poll);
                sum1 += poll;
                sum2 -= poll;
                count++;
            } 
        }
        return count;
    }
}