import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] oper = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr, oper, arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int[] arr, int[] oper, int num, int idx) {
        if (idx == arr.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;

                switch (i) {
                    case 0 : dfs(arr, oper, num+arr[idx], idx + 1); break;
                    case 1 : dfs(arr, oper, num-arr[idx], idx + 1); break;
                    case 2 : dfs(arr, oper, num*arr[idx], idx + 1); break;
                    case 3 : dfs(arr, oper, num/arr[idx], idx + 1); break;
                }

                oper[i]++;
            }
        }
    }
}
