import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 1_000_000_000;

        long[][] dp = new long[n+1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1; // N이 1일 경우, 계단 수를 1로 초기화
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < 10; j++) {
                long val;
                if (j == 9) {
                    val = dp[i-1][8] % mod;
                } else if (j == 0) {
                    val = dp[i-1][1] % mod;
                } else {
                    val = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
                dp[i][j] = val;
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }

        System.out.println(answer % mod);
    }
}