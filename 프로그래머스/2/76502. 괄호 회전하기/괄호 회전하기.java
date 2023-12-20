import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] arr = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        
        for (char bracket : arr) {
            deque.offer(bracket);
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (checkBracket(deque.iterator())) {
                answer++;
                i++;
                deque.offerLast(deque.pollFirst());
            }
            deque.offerLast(deque.pollFirst());
        }
        
        return answer;
    }
    
    boolean checkBracket(Iterator<Character> iterator) {
        Stack<Character> stack = new Stack<>();
        while (iterator.hasNext()) {
            char bracket = iterator.next();
            if (stack.isEmpty() && (bracket == ')' || bracket == ']' || bracket == '}')) {
                return false;
            }
            
            if (!stack.isEmpty() && (stack.peek()+2 == bracket || stack.peek()+1 == bracket)) {
                stack.pop();
            } else {
                stack.push(bracket);
            }
        }
        
        return stack.isEmpty();
    }
}