import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        
        final String IN = "님이 들어왔습니다.";
        final String OUT = "님이 나갔습니다.";
        Map<String, String> nicknameMap = new HashMap<>();
        List<String[]> actionList = new ArrayList<>();
        
        for (String record : records) {
            String[] split = record.split(" ");
            
            String action = split[0];
            
            if ("Enter".equals(action)) {
                nicknameMap.put(split[1], split[2]);
                actionList.add(new String[]{split[1], IN});
            } else if ("Change".equals(action)) {
                nicknameMap.put(split[1], split[2]);
            } else if ("Leave".equals(action)) {
                actionList.add(new String[]{split[1], OUT});
            }
        }
        
        String[] answer = new String[actionList.size()];
        for (int i = 0; i < answer.length; i++) {
            String[] id = actionList.get(i);
            answer[i] = new StringBuilder(nicknameMap.get(id[0])).append(id[1]).toString();
        }

        return answer;
    }
}