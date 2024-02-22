import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(String[] board) {
        boolean[][] visited = new boolean[board.length][board[0].length()];
        Queue<int[]> queue = new LinkedList<>();

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length(); x++) {
                if (board[y].charAt(x) == 'R') {
                    queue.add(new int[]{y, x, 0});
                    visited[y][x] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] nodeIndex = queue.poll();
            int y = nodeIndex[0];
            int x = nodeIndex[1];
            int count = nodeIndex[2];

            if (board[y].charAt(x) == 'G') {
                return count;
            }

            int dx = 1;
            int dy = 1;

            while (y - dy != -1 && board[y - dy].charAt(x) != 'D') {
                dy++;
            }

            if (!visited[y - dy + 1][x]) {
                queue.add(new int[]{y - dy + 1, x, count + 1});
                visited[y - dy + 1][x] = true;
            }

            dy = 1;
            while (y + dy != board.length && board[y + dy].charAt(x) != 'D') {
                dy++;
            }

            if (!visited[y + dy - 1][x]) {
                queue.add(new int[]{y + dy - 1, x, count + 1});
                visited[y + dy - 1][x] = true;
            }

            while (x - dx != -1 && board[y].charAt(x - dx) != 'D') {
                dx++;
            }

            if (!visited[y][x - dx + 1]) {
                queue.add(new int[]{y, x - dx + 1, count + 1});
                visited[y][x - dx + 1] = true;
            }

            dx = 1;
            while (x + dx != board[y].length() && board[y].charAt(x + dx) != 'D') {
                dx++;
            }

            if (!visited[y][x + dx - 1]) {
                queue.add(new int[]{y, x + dx - 1, count + 1});
                visited[y][x + dx - 1] = true;
            }
        }
        
        return -1;
    }
}