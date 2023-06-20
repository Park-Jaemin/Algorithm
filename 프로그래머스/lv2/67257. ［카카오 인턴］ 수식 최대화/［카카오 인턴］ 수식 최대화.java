import java.util.*;

class Solution {
    long answer = 0;
    String[] operatorType = {"+", "-", "*"};
    List<Long> numbers = new ArrayList<>();
    List<String> operators = new ArrayList<>();
    
    public long solution(String expression) {
        for (String num : expression.split("[-+*]+")) {
            numbers.add(Long.parseLong(num));
        }
        operators.addAll(List.of(expression.split("[^-+*]+")));
        operators.remove(0);


        dfs(new String[3], 0, new boolean[3]);

        return answer;
    }
    
    void dfs(String[] operator, int depth, boolean[] visit) {
        if (depth == operator.length) {
            List<Long> copyNumbers = new ArrayList<>(numbers);
            List<String> copyOperators = new ArrayList<>(operators);

            for (String s : operator) {
                for (int j = 0; j < copyOperators.size(); j++) {
                    if (!s.equals(copyOperators.get(j))) continue;
                    long value = calculate(copyNumbers.remove(j), copyNumbers.remove(j), copyOperators.remove(j));
                    copyNumbers.add(j, value);
                    j--;
                }
            }
            answer = Math.max(answer, Math.abs(copyNumbers.get(0)));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            operator[depth] = operatorType[i];
            dfs(operator, depth+1, visit);
            visit[i] = false;
        }
    }
    
    long calculate(long num1, long num2, String operator) {
        if (operator.equals("*")) {
            return num1 * num2;
        } else if (operator.equals("+")) {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }
}