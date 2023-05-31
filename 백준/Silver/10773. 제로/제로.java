import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) stack.pop();
            else stack.push(value);
        }

        int sum = 0;
        for (int num : stack) {
            sum += num;
        }
        System.out.println(sum);
    }
}