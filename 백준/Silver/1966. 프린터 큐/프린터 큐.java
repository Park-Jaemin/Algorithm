import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            LinkedList<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, value});
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                boolean max = true;

                for (int i = 0; max && i < queue.size(); i++) {
                    if (poll[1] < queue.get(i)[1]) {
                        queue.offer(poll);

                        for (int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }
                        max = false;
                    }
                }

                if (!max) continue;

                count++;
                if (poll[0] == m) break;
            }
            
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}