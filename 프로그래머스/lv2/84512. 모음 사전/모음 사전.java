import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String word) {
        int answer = word.length();

        List<String> list = new ArrayList<>();
        String[] dictionary = {"A", "E", "I", "O", "U"};
        recursion(list, dictionary, "", 0);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    void recursion(List<String> list, String[] dictionary, String str, int depth) {
        list.add(str);

        if(depth == 5) {
            return;
        }

        for (String s : dictionary) {
            recursion(list, dictionary, str + s, depth + 1);
        }
    }
}