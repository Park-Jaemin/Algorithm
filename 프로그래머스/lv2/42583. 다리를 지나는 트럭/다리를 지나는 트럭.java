import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int sum = 0;
        int answer = 0;

        for (int truck : truck_weights) {
            while (true) {
                if (bridge.isEmpty() || (bridge.size() != bridge_length && sum + truck <= weight)) {
                    bridge.add(truck);
                    sum += truck;
                    answer++;
                    break;
                }

                if (bridge.size() == bridge_length) {
                    sum -= bridge.poll();
                } else {
                    bridge.add(0);
                    answer++;
                }
            }
        }

        return answer + bridge_length;
    }
}