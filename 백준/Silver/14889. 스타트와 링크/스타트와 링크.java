import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs(int idx, int count) {
        if (count == map.length / 2) {
            diff();
            return;
        }

        for (int i = idx; i < map.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < map.length - 1; i++) {
            for (int j = i + 1; j < map.length; j++) {
                if (visit[i] && visit[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        int val = Math.abs(start - link);
        
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        
        min = Math.min(val, min);
    }
}
