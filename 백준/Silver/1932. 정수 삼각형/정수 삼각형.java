import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n-1; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.arraycopy(arr[n-1], 0, dp[n-1], 0, n);

        System.out.println(dp(n, 0, 0, dp, arr));
    }

    static int dp(int n, int d, int i, int[][] dp, int[][] arr) {
        if (d == n - 1) return dp[d][i];

        if (dp[d][i] == -1) {
            dp[d][i] = Math.max(dp(n, d+1, i, dp, arr), dp(n, d+1, i+1, dp, arr)) + arr[d][i];
        }
        return dp[d][i];
    }
}