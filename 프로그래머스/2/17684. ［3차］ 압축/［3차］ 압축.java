import java.util.*;

class Solution {
    public Integer[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = define();
        
        int i = 0;
        while (i < msg.length()) {
            String word = "";
            
            while (i < msg.length() && dictionary.containsKey((word += msg.charAt(i)))) {
                i++;
            }
            
            if (!dictionary.containsKey(word)) {
                dictionary.put(word.toString(), dictionary.size() + 1);
            }
            
            String key = i == msg.length() ?
                    word.toString() : word.substring(0, word.length() - 1);

            answer.add(dictionary.get(key));
        }
        
        return answer.toArray(answer.toArray(new Integer[0]));
    }
    
    Map<String, Integer> define() {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i <= 'Z'-'A'; i++) {
            map.put(String.valueOf((char)('A'+i)), i+1);
        }
        
        return map;
    }
}