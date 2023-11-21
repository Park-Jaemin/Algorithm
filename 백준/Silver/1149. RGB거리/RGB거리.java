import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int size = 3;
        arr = new int[n][size];
        dp = new int[n][size];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.arraycopy(arr[0], 0, dp[0], 0, size);

        System.out.println(Math.min(Math.min(dp(n-1, 0), dp(n-1, 1)), dp(n-1, 2)));
    }

    static int dp(int d, int i) {
        if (dp[d][i] == 0) {
            if (i == 0) {
                dp[d][i] = Math.min(dp(d - 1, 1), dp(d - 1, 2)) + arr[d][i];
            }
            if (i == 1) {
                dp[d][i] = Math.min(dp(d - 1, 0), dp(d - 1, 2)) + arr[d][i];
            }
            if (i == 2) {
                dp[d][i] = Math.min(dp(d - 1, 0), dp(d - 1, 1)) + arr[d][i];
            }
        }

        return dp[d][i];
    }
}