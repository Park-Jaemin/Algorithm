import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int sco : scoville) {
            queue.offer(sco);
        }
        
        while (queue.peek() < K) {
            
            if (queue.size() == 1) return -1;

            int sco1 = queue.poll();
            int sco2 = queue.poll() * 2;
            
            queue.offer(sco1 + sco2);
        }
        
        return scoville.length - queue.size();
    }
}