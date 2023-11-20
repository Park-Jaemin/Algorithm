import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board;
    static int before;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        findTree(0, 0, n);

        System.out.println(sb);
    }

    static void findTree(int x, int y, int size) {
        if (checkAllSame(x, y, size)) {
            sb.append(before);
            return;
        }

        size = size / 2;
        sb.append("(");
        findTree(x, y, size);
        findTree(x, y + size, size);
        findTree(x + size, y, size);
        findTree(x + size, y + size, size);
        sb.append(")");
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