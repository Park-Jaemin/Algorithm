import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();

        while (N-- > 0) {
            String line = br.readLine();

            if (line.length() > 2) {
                if (line.charAt(0) == '1') {
                    deque.addFirst(Integer.parseInt(line.substring(2)));
                } else {
                    deque.addLast(Integer.parseInt(line.substring(2)));
                }
                continue;
            }

            int num = 0;
            switch (line) {
                case "3" :
                    num = deque.isEmpty() ? -1 : deque.pollFirst();
                    break;
                case "4" :
                    num = deque.isEmpty() ? -1 : deque.pollLast();
                    break;
                case "5" :
                    num = deque.size();
                    break;
                case "6" :
                    num = deque.isEmpty() ? 1 : 0;
                    break;
                case "7" :
                    num = deque.isEmpty() ? -1 : deque.peekFirst();
                    break;
                case "8" :
                    num = deque.isEmpty() ? -1 : deque.peekLast();
                    break;
            }
            answer.append(num).append("\n");
        }
        System.out.println(answer);
    }
}