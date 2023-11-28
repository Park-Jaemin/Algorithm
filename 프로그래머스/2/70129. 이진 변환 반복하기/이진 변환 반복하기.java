import java.util.*;

class Solution {
    int[] answer;
    public int[] solution(String s) {
        answer = new int[2];
        toBinary(s);
        return answer;
    }
    
    void toBinary(String s) {
        if (s.equals("1")) return;
        
        StringBuilder s2 = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, "0");
        while (st.hasMoreElements()) {
            s2.append(st.nextToken());
        }
        
        answer[0]++;
        answer[1] += s.length() - s2.length();
        
        toBinary(Integer.toBinaryString(s2.length()));
    }
}