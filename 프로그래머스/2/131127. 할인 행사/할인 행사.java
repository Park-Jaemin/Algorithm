import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        for (; i < 10; i++) {
            String product = discount[i];
            map.put(product, map.getOrDefault(product, 0) + 1);
        }

        for (int j = 0; i < discount.length; j++) {
            answer += check(want, number, map) ? 1 : 0;
            
            String addProduct = discount[i];
            String minusProduct = discount[j];
            
            map.put(addProduct, map.getOrDefault(addProduct, 0) + 1);
            map.put(minusProduct, map.get(minusProduct) - 1);
            i++;
        }
        return answer += check(want, number, map) ? 1 : 0;
    }
    
    boolean check(String[] want, int[] number, Map<String, Integer> map) {
        for (int i = 0; i < want.length; i++) {
            if (map.get(want[i]) == null || number[i] != map.get(want[i])) return false;
        }

        return true;
    }
}