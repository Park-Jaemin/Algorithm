import java.util.*;

class Solution {
    public int solution(int[] order) { 
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            if (order[index] == i) {
                index++;
                
                while (!stack.isEmpty() && stack.peek() == order[index]) {
                    index++;
                    stack.pop();
                }
                
            } else {
                stack.push(i);
            }
        }
        
        return index;
    }
}