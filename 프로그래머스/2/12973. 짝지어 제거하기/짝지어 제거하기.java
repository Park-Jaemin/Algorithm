import java.util.*;

class Solution {
    public int solution(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : charArray) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}