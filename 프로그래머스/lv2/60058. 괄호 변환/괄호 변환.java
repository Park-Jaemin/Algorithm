import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";

        if (checkCollect(p)) {
            return p;
        }

        int index = getPairIndex(p);
        String u = p.substring(0, index);
        String v = p.substring(index);

        if (checkCollect(u)) {
            answer += u + solution(v);
        } else {
            String temp = "(" + solution(v) + ")";
            answer += temp + replace(u.substring(1, u.length()-1));
        }

        return answer;
    }
    
    boolean checkCollect(String p) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
    
    int getPairIndex(String p) {
        int left = 0;
        int right = 0;
        int idx = 0;

        do {
            if (p.charAt(idx++) == '(') {
                left++;
            } else {
                right++;
            }
        } while (left != right);

        return left+right;
    }
    
    String replace(String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}