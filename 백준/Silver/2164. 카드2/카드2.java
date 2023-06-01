import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= count; i++) {
            deque.offer(i);
        }
        while (--count > 0) {
            deque.pop();
            deque.offer(deque.pop());
        }
        System.out.println(deque.pop());
    }
}