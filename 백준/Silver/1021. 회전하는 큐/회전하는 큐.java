import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        int[] answer = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            int target = deque.indexOf(answer[i]);
            int half = deque.size() / 2;

            if (deque.size() % 2 == 0) {
                half = deque.size() / 2 - 1;
            }

            if(target <= half) {
                for(int j = 0; j < target; j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            } else {
                for(int j = 0; j < deque.size() - target; j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }

        System.out.println(count);
    }
}