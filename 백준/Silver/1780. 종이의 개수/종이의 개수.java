import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int before;
    static int plus;
    static int zero;
    static int minus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findCount(0, 0, n);

        System.out.println(minus + "\n" + zero + "\n" + plus);
    }

    static void findCount(int x, int y, int size) {
        if (checkAllSame(x, y, size)) {
            if (before == 1) plus++;
            if (before == 0) zero++;
            if (before == -1) minus++;
            return;
        }

        size = size / 3;
        findCount(x, y, size);
        findCount(x, y + size, size);
        findCount(x, y + size + size, size);
        findCount(x + size, y, size);
        findCount(x + size, y + size, size);
        findCount(x + size, y + size + size, size);
        findCount(x + size + size, y, size);
        findCount(x + size + size, y + size, size);
        findCount(x + size + size, y + size + size, size);
    }

    static boolean checkAllSame(int x, int y, int size) {
        before = board[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != before) return false;
            }
        }

        return true;
    }
}