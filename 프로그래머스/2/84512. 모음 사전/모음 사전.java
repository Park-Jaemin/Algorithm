class Solution {
    
    char[] words = {'A', 'E', 'I', 'O', 'U'};
    int count = 0;
    
    public int solution(String word) {
        dfs(word, new StringBuilder());
        return count;
    }
    
    void dfs(String word, StringBuilder now) {      
        if (now.toString().equals(word) || now.length() == words.length) {
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            count++;
            now.append(words[i]);
            dfs(word, now);
            
            if (now.toString().equals(word)) {
                return;
            }
            
            now.deleteCharAt(now.length()-1);
        }
    }
}