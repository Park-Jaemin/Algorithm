import java.util.*;

class Solution {
    public int[] solution(String s) {
        boolean[] used = new boolean[100_001];
        
        String[] arr = s.split("\\{\\{|\\},\\{|\\}\\}");
        int[] answer = new int[arr.length-1];
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());

        for (int i = 1; i < arr.length; i++) {
            for (String n : arr[i].split(",")) {
                int num = Integer.parseInt(n);
                if (!used[num]) {
                    answer[i-1] = num;
                    used[num] = true;
                    break;
                }
            }
        }
        
        return answer;
    }
}