import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
        
        Queue<Stack<Integer>> roomList = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.peek(), o2.peek()));
        for (String[] time : book_time) {
            if (roomList.isEmpty() || roomList.peek().peek() > convertTime(time[0])) {
                offerRoomList(new Stack<Integer>(), time[1], roomList);
            } else {
                offerRoomList(roomList.poll(), time[1], roomList);
            }
        }
        
        return roomList.size();
    }
    
    int convertTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    void offerRoomList(Stack<Integer> stack, String time, Queue<Stack<Integer>> queue) {
                stack.push(convertTime(time) + 10);
                queue.offer(stack);
    }
}