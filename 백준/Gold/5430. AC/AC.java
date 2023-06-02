import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            LinkedList<Integer> deque = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            command(p, deque);
        }
        System.out.println(sb);
    }

    private static void command(String p, LinkedList<Integer> deque) {
        boolean flag = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == 'R') {
                flag = !flag;
                continue;
            }

            if(flag) {
                if(deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if(deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        makeString(deque, flag);
    }

    private static void makeString(LinkedList<Integer> deque, boolean flag) {
        sb.append('[');

        if(deque.size() > 0) {
            if(flag) {
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');	// 닫는 대괄호 및 개행으로 마무리
    }
}