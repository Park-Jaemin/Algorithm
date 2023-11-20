import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int blue = 0;
    static int white = 0;
    static int color = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findCount(0, 0, n);
        System.out.println(white + "\n" + blue);
    }

    static void findCount(int x, int y, int size) {
        if (checkSameColor(x, y, size)) {
            if (color == 0) white++;
            else blue++;
            return;
        }

        size = size / 2;
        findCount(x, y, size); // 1
        findCount(size + x, y, size); // 2
        findCount(x, y + size, size); // 3
        findCount(x + size, y + size, size); // 4
    }

    static boolean checkSameColor(int x, int y, int size) {
        color = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) return false;
            }
        }

        return true;
    }
}