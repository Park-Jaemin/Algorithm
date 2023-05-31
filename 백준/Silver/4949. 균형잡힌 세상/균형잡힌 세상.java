import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while (!(line = br.readLine()).equals(".")) {
            String replace = line.replaceAll("[a-zA-Z .]", "");
            boolean check = true;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < replace.length(); i++) {
                char c = replace.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else {
                    c = c == ')' ? '(' : '[';
                    if (stack.size() == 0 || c != stack.peek()) {
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!check || stack.size() > 0 ) {
                sb.append("no");
            } else {
                sb.append("yes");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}