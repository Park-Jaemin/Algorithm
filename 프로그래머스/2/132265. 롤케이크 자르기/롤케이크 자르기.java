import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for (int type : topping) {
            left.put(type, left.getOrDefault(type, 0) + 1);
        }
        
        for (int type : topping) {
            right.put(type, right.getOrDefault(type, 0) + 1);
            
            if (left.get(type) != null) {
                left.put(type, left.get(type) - 1);
            }
            
            if (left.get(type) == 0) {
                left.remove(type);
            }
            
            if (left.size() == right.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}