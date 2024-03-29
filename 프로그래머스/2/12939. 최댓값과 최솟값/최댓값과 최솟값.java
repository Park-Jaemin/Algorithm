import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " "); // "1 2"
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        while (st.hasMoreElements()) {
            int num = Integer.parseInt(st.nextToken());
            
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        
        
        return min + " " + max;
    }
}