import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] sum = new int[s.length()+1]['z'-'a'+1];
        sum[1][s.charAt(0)-'a'] = 1;
        for (int i = 2; i < s.length()+1; i++) {
            int c = s.charAt(i-1) - 'a';
            sum[i] = Arrays.copyOf(sum[i-1], 'z'-'a'+1);
            sum[i][c] = sum[i-1][c] +1;
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken())+1;

            sb.append(sum[r][a] - sum[l][a]).append("\n");
        }

        System.out.println(sb);
    }
}