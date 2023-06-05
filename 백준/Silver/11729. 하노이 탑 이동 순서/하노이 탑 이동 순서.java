import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        sb.append((int) Math.pow(2, n) - 1).append("\n");
        hanoi(n, 1, 2, 3);
        System.out.println(sb);
    }

    static void hanoi(int n, int from, int mid, int to) {
        if (n == 1) {
            append(from, to);
            return;
        }

        hanoi(n - 1, from, to, mid);
        append(from, to);
        hanoi(n - 1, mid, from, to);
    }

    static void append(int from, int to) {
        sb.append(from).append(" ").append(to).append("\n");
    }
}
