import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int row = Integer.parseInt(arr[0]);
        int col = Integer.parseInt(arr[1]);

        boolean[][] board = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = line.charAt(j) != 'B';
            }
        }

        int answer = 64;
        for (int i = 0; i < row - 7; i++) {
            for (int j = 0; j < col - 7; j++) {
                int count = 0;
                boolean color = board[i][j];

                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        count = board[x][y] != color ? count+1 : count;

                        color = !color;
                    }
                    color = !color;
                }
                count = Math.min(count, 64 - count);
                answer = Math.min(answer, count);
            }
        }

        System.out.println(answer);
    }
}