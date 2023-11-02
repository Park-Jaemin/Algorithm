import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        while (N-- > 0) {
            String line = br.readLine();

            if (line.length() > 2) {
                stack.push(Integer.parseInt(line.substring(2)));
                continue;
            }

            int num;
            if (line.equals("2")) {
                num = stack.empty() ? -1 : stack.pop();
            } else if (line. equals("3")) {
                num = stack.size();
            } else if (line.equals("4")) {
                num = stack.empty() ? 1 : 0;
            } else {
                num = stack.empty() ? -1 : stack.peek();
            }
            answer.append(num).append("\n");
        }
        System.out.println(answer);
    }
}