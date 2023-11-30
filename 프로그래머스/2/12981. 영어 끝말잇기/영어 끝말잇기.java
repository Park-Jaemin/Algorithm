import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> useWords = new HashSet<String>();
        
        char before = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int size = useWords.size();
            useWords.add(word);
            
            int people = (i+1) % n == 0 ? n : (i+1) % n;
            int order = i / n + 1;
            
            if (before != word.charAt(0)) {
                return new int[]{people, order};
            }
            if (size == useWords.size()) {
                return new int[]{people, order};
            }
            
            before = word.charAt(word.length()-1);
        }
        
        return new int[]{0,0};
    }
}