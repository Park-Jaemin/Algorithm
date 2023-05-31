import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) ->
                Integer.parseInt(String.valueOf(o2)+o1) - Integer.parseInt(String.valueOf(o1)+o2));
        for (int num : numbers) {
            queue.offer(num);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}