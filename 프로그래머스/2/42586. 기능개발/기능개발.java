import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.offer((int) Math.ceil((100 - progresses[i]) / (double) speeds[i]));
        }
        
        System.out.println(queue);
        
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int count = 1;
            
            while (!queue.isEmpty() && queue.peek() <= now) {
                queue.poll();
                count++;
            }
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}