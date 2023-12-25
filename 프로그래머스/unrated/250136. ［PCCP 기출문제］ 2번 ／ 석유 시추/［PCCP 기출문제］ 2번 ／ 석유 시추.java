import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int[] pipes = new int[land[0].length];
        boolean[][] visit = new boolean[land.length][land[0].length];
        
        for (int col = 0; col < land[0].length; col++) {
            for (int row = 0; row < land.length; row++) {
                if (!visit[row][col] && land[row][col] == 1) {
                    visit[row][col] = true;
                    bfs(row, col, visit, pipes, land);
                }
            }
        }
        
        int answer = 0;
        for (int count : pipes) {
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
    
    void bfs(int row, int col, boolean[][] visit, int[] pipes, int[][] land) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> cols = new HashSet<>();
        queue.offer(new int[]{row, col});
        int count = 0;
        
        while (!queue.isEmpty()) {
            count++;
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[0];
            cols.add(x);
            
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (!inRange(nx, ny, land)) continue;
                if (!visit[ny][nx] && land[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
        
        addPipes(cols, pipes, count);
    }
    
    boolean inRange(int x, int y, int[][] land) {
        return x >= 0 && y >= 0 && x < land[0].length && y < land.length;
    }
    
    void addPipes(Set<Integer> cols, int[] pipes, int count) {
        for (int col : cols) {
            pipes[col] += count;
        }
    }
}