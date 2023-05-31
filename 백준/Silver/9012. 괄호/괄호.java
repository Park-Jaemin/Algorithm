import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.size() == 0) {
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!check || stack.size() > 0) {
                sb.append("NO");
            } else {
                sb.append("YES");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}