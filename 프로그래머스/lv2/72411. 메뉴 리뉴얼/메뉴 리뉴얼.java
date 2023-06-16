import java.util.*;

class Solution {
    
    HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        List<String> answer = new ArrayList<>();
        for (int c : course) {
            for (String order : orders) {
                combination("", order, c);
            }

            if (!map.isEmpty()) {
                Collection<Integer> values = map.values();
                int max = Collections.max(values);
                if (max > 1) {
                    for (String menu : map.keySet()) {
                        if (map.get(menu) == max) {
                            answer.add(menu);
                        }
                    }
                }
                map.clear();
            }
        }
        
        answer.sort(String::compareTo);
        return answer.toArray(new String[0]);
    }
    
    void combination(String menu, String order, int c) {
        if (c == 0) {
            map.put(menu, map.getOrDefault(menu, 0)+1);
            return;
        }

        for (int i = 0; i < order.length(); i++) {
            combination(menu + order.charAt(i), order.substring(i + 1), c - 1);
        }
    }
}