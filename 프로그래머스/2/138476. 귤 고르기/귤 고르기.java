import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new TreeMap<>();
        for (int key : tangerine) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));

        for (Integer key : list) {
            k -= map.get(key);
            answer++;
            
            if (k <= 0) break;
        }
        
        return answer;
    }
}