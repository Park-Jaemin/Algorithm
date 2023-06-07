import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int count;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        count = 0;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dfs(n, 0);
        System.out.println(count);
    }

    static void dfs(int n, int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (isPossible(depth)) {
                dfs(n, depth + 1);
            }
        }
    }

    static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i]) return false;
            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) return false;
        }
        return true;
    }
}
