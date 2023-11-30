import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // 1. List 에 쌓기
        // 3. 이전 글자로 시작하는지 체크하고 기존 List 에 있는지 체크

        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            answer[0] = (i + 1) % n != 0 ? (i + 1) % n : n;
            answer[1] = (i + 1) % n != 0 ? ((i + 1) / n) + 1 : (i + 1) / n;

            if (i != 0 && words[i - 1].charAt(words[i - 1].length()-1) != words[i].charAt(0)) {
                return answer;
            }


            if (wordList.contains(words[i])) {
                return answer;
            }

            wordList.add(words[i]);
        }
        return new int[]{0,0};
    }
}