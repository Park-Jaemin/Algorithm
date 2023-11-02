import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int front = Integer.parseInt(br.readLine());
        String[] number = br.readLine().split(" ");

        Stack<Integer> stack = new Stack<>();
        int count = 1;

        for (int i = 0; i < front; i++) {
            int num = Integer.parseInt(number[i]);

            if (count == num) {
                count++;
                continue;
            }

            if (!stack.empty() && count == stack.peek()) {
                count++;
                stack.pop();
                i--;
                continue;
            }

            if (!stack.empty()) {
                if (stack.peek() < num) {
                    System.out.println("Sad");
                    return;
                } else {
                    stack.push(num);
                }
            } else {
                stack.push(num);
            }
        }
        System.out.println("Nice");
    }
}