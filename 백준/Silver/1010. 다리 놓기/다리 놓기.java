import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[30][30];
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(combi(dp, M, N)).append("\n");
        }
        System.out.println(sb);
    }

    private static int combi(int[][] dp, int n, int r) {
        if(dp[n][r] > 0) {
            return dp[n][r];
        }

        if(n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combi(dp, n - 1, r - 1) + combi(dp, n - 1, r);
    }
}