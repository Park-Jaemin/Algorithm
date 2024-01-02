import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(numbers).boxed()
                .sorted((o1, o2) -> (String.valueOf(o2) + o1).compareTo(String.valueOf(o1) + o2))
                .forEach(sb::append);

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}