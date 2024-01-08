import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Arrays.sort(records, (o1, o2) -> {
            String number1 = o1.substring(6, 10);
            String number2 = o2.substring(6, 10);
            if (number1.equals(number2)) {
                return o1.substring(0, 5).compareTo(o2.substring(0, 5));
            }
            return number1.compareTo(number2);
        });
        
        System.out.println(Arrays.toString(records));

        Stack<String> stack = new Stack<>();
        Map<String, Long> map = new TreeMap<>();
        for (String record : records) {
            if (stack.isEmpty()) {
                stack.push(record);
                continue;
            }

            String car = stack.pop();
            if (car.substring(6, 10).equals(record.substring(6, 10))) {
                put(car.substring(6, 10), car.substring(0, 5), record.substring(0, 5), map);
            } else {
                put(car.substring(6, 10), car.substring(0, 5), "23:59", map);
                stack.push(record);
            }
        }

        if (!stack.isEmpty()) {
            String car = stack.pop();
            put(car.substring(6, 10), car.substring(0, 5), "23:59", map);
        }

        int[] answer = new int[map.size()];
        int i = 0;
        for (long time : map.values()) {
            int fee = fees[1];
            if (time > fees[0]) {
                fee += (int) (Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3]);
            }
            answer[i++] = fee;
        }

        return answer;
    }
    
    void put(String number, String inTime, String outTime, Map<String, Long> map) {
        map.put(number, map.getOrDefault(number, 0L) + calcTime(inTime, outTime));
    }
    
    long calcTime(String inTime, String outTime) {
        return ChronoUnit.MINUTES.between(LocalTime.parse(inTime), LocalTime.parse(outTime));
    }
}
