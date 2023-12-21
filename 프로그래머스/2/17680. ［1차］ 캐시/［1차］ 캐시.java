import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedList<String> list = new LinkedList<>();
        
        for (String city : cities) {
            city = city.toLowerCase();
            if (list.contains(city)) {
                answer++;
                list.remove(city);
                list.offerFirst(city);
            } else {
                answer += 5;
                list.offerFirst(city);
                if (list.size() > cacheSize) list.pollLast(); 
            }
        }
        
        return answer;
    }
}