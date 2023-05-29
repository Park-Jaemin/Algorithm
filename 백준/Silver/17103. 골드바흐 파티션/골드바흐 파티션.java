import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        boolean[] num = new boolean[1000001];
        num[0] = num[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!num[i]) {
                for (int j = i + i; j <= 1000000; j += i) {
                    num[j] = true;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        while (count-- > 0) {
            int input = Integer.parseInt(br.readLine());
            int answer = 0;
            for (int i = 2; i <= input / 2; i++) {
                if (!num[i] && !num[input - i]) answer++;
            }
            builder.append(answer).append("\n");
        }

        System.out.println(builder);
    }
}