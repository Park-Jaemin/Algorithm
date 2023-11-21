import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine())+1;
        arr = new int[size];
        dp = new Integer[size];

        for (int i = 1; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];
        if (size >= 3) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(dp(size-1));
    }

    static int dp(int depth) {
        if (dp[depth] == null) {
            dp[depth] = Math.max(dp(depth-2), dp(depth-3) + arr[depth-1]) + arr[depth];
        }
        return dp[depth];
    }
}