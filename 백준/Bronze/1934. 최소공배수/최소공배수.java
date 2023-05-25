import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()); // 큰 수, 작은 수 구별?
            int b = Integer.parseInt(st.nextToken());

            int c = a;
            int d = b;
            while (d != 0) {
                int temp = c % d;
                c = d;
                d = temp;
            }

            builder.append(a*b/c).append("\n");
        }
        System.out.println(builder);
    }
}