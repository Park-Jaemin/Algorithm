import java.util.*;

class Solution {
    public int[] solution(String s) {
        return toBinary(s, new int[2]);
    }
    
    int[] toBinary(String s, int[] answer) {
        if (s.equals("1")) return answer;
        
        StringBuilder s2 = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, "0");
        while (st.hasMoreElements()) {
            s2.append(st.nextToken());
        }
        
        answer[0]++;
        answer[1] += s.length() - s2.length();
        
        return toBinary(Integer.toBinaryString(s2.length()), answer);
    }
}