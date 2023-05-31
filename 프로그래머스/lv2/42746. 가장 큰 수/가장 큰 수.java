import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(nums, (o1, o2) ->
                Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2));

        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
            if (sb.charAt(0) == '0') return "0";
        }

        return sb.toString();
    }
}