import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        int max = 23*60 + 59;

        Set<String> numbers = new HashSet<>();
        Queue<Car> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.number.equals(o2.number)) return o1.time - o2.time;
            return o1.number.compareTo(o2.number);
        });
        for (String info : records) {
            numbers.add(info.substring(6, 10));
            queue.offer(new Car(info.substring(6, 10), info.substring(0, 5)));
        }
        int[] answer = new int[numbers.size()];
        int i = 0;

        while (!queue.isEmpty()) {
            Car car = queue.poll();
            int outTime = max;

            if (!queue.isEmpty() && queue.peek().number.equals(car.number)) {
                outTime = queue.poll().time;
            }

            int time = outTime - car.time;
            answer[i] += time;

            if (!queue.isEmpty() && !queue.peek().number.equals(car.number)) {
                i++;
            }
        }

        for (int y = 0; y < answer.length; y++) {
            int time = answer[y];
            if (time <= basicTime) {
                answer[y] = basicFee;
            } else {
                int i1 = (int) Math.ceil((double) (time - basicTime) / unitTime);
                answer[y] = i1 * unitFee + basicFee;
            }
        }

        return answer;
    }
}
class Car {
    String number;
    int time;

    Car(String number, String time) {
        String[] split = time.split(":");
        this.number = number;
        this.time = Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
    }
}