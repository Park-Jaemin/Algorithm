import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int count = friends.length;
        Map<String, Integer> map = mapToIndex(count, friends);
        
        int[][] route = new int[count][count];
        int[] giftPower = new int[count];
        getRouteAndGiftPower(route, giftPower, gifts, map);

        return getMaxGiftCount(route, giftPower);
    }
    
    Map<String, Integer> mapToIndex(int count, String[] friends) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < count; i++) {
            map.put(friends[i], i);
        }
        
        return map;
    }
    
    void getRouteAndGiftPower(int[][] route, int[] giftPower, String[] gifts, Map<String, Integer> map) {
        for (String gift : gifts) {
            String[] people = gift.split(" ");
            int giver = map.get(people[0]);
            int receiver = map.get(people[1]);
            
            giftPower[giver]++;
            giftPower[receiver]--;
            route[giver][receiver]++;
        }
    }
    
    int getMaxGiftCount(int[][] route, int[] giftPower) {
        int max = 0;
        for (int i = 0; i < route.length; i++) {
            int nextGiftCount = 0;
            for (int j = 0; j < route.length; j++) {
                if (i == j) continue;
                
                if (route[i][j] > route[j][i]) {
                    nextGiftCount++;
                }
                
                if (route[i][j] == route[j][i] && giftPower[i] > giftPower[j]) {
                    nextGiftCount++;
                }
                
            }
            max = Math.max(max, nextGiftCount);
        }
        
        return max;
    }
}