import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> deque = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]);
            deque.offerLast(new int[]{priorities[i], i});
        }
        
        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int priority = poll[0];
            int index = poll[1];
            
            if (queue.peek() == priority) {
                queue.poll();
                answer++;
                if (index == location) break;
            } else {
                deque.offerLast(poll);
            }
        }
        
        return answer;
    }
}