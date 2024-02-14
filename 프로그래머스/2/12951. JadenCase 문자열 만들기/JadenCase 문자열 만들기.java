import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.toLowerCase().split(""); 
        boolean first = true;
        
        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            if (word.equals(" ")) {
                first = true;
                sb.append(word);
                continue; 
            }
            
            if (first) {
                word = word.toUpperCase();
                first = false;
            }
            
            sb.append(word);
        }
        
        return sb.toString();
    }
}