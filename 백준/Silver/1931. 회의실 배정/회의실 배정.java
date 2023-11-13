import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        int[][] meeting = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return Integer.compare(o1[1], o2[1]);
        });

        int before = 0;
        for (int[] time : meeting) {
            if (before > time[0]) continue;

            answer++;
            before = time[1];
        }

        System.out.println(answer);
    }
}