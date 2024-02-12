import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
        
        Queue<Integer> roomList = new PriorityQueue<>();
        for (String[] time : book_time) {
            if (!roomList.isEmpty() && roomList.peek() <= convertTime(time[0])) {
                roomList.poll();
            }
            roomList.offer(convertTime(time[1]) + 10);
        }
        
        return roomList.size();
    }
    
    int convertTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}