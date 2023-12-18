class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        boolean[][][] visit = new boolean[11][11][4];
        int[] dx = {0,-1,0,1};
        int[] dy = {-1,0,1,0};
        
        int x = 5;
        int y = 5;
        int dir = 0;
        
        for (int i = 0; i < dirs.length(); i++) {           
            switch (dirs.charAt(i)) {
                case 'U' : dir = 0; break;
                case 'L' : dir = 1; break;
                case 'D' : dir = 2; break;
                case 'R' : dir = 3; break;
            }
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;
            if (!visit[nx][ny][dir]) {
                visit[nx][ny][dir] = true;
                dir = (dir % 2 == 0) ? 2-dir : 4-dir;
                visit[x][y][dir] = true;
                answer++;
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}