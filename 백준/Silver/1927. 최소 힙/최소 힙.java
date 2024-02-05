import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int size = Integer.parseInt(br.readLine());
        while (size-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(queue.isEmpty() ? 0 : queue.poll());
                if (size > 0) sb.append("\n");
            } else {
                queue.offer(num);
            }
        }
        System.out.println(sb);
    }
}