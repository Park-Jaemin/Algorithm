import java.util.*;


/*
    1. 통로를 통해 레버가 도착 -> 즉, 레버를 도착하기 전의 출구는 통로와 동일
    2. 레버 도착 후, 출구로 도착
*/

class Solution {
    
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    int[] S = new int[2];
    int[] L = new int[2];
    int[] E = new int[2];
    
    public int solution(String[] maps) {
        int[][] map = new int[maps.length][maps[0].length()]; // L까지 도달하는 미로
        int[][] map2 = new int[maps.length][maps[0].length()]; // L이후 E까지 도달하는 미로
        
        // 초기화 시켜주기
        define(maps, map, map2);
        
        // S부터 L까지 최단 거리
        int target = bfs(map, S, L);
        if (target == -1) return target;
        
        // L이후 E까지 최단 거리
        map2[L[0]][L[1]] = target;
        return bfs(map2, L, E);
    }
    
    private void define(String[] maps, int[][] map, int[][] map2) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                
                if (c == 'X') continue;
                
                map[i][j] = 1;
                map2[i][j] = 1;
                
                if (c == 'S') {
                    S[0] = i;
                    S[1] = j;
                    map[i][j] = 0;
                }
                
                if (c == 'L') {
                    L[0] = i;
                    L[1] = j;
                }
                
                if (c == 'E') {
                    E[0] = i;
                    E[1] = j;
                }
            }
        }
    }
    
    private int bfs(int[][] map, int[] start, int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            if (x == target[0] && y == target[1]) return map[x][y];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if (map[nx][ny] == 1) {
                    map[nx][ny] += map[x][y];
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}