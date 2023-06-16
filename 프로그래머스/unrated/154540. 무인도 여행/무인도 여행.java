import java.util.*;

class Solution {
    
    int[] diry = {-1, 0, 1, 0};
    int[] dirx = {0, 1, 0, -1};
    char[][] map;
    boolean[][] visit;
    
    public int[] solution(String[] maps) {
        visit = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][];
        for (int i = 0; i < map.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        List<Integer> answer = new ArrayList<>();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] != 'X' && !visit[y][x]) {
                    visit[y][x] = true;
                    int val = bfs(y, x);
                    if (val != 0) {
                        answer.add(answer.size(), val);
                    }
                }
            }
        }
        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        answer.sort(Integer::compareTo);
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    int bfs(int y, int x) {
        int val = Integer.parseInt(String.valueOf(map[y][x]));
        for (int i = 0; i < 4; i++) {
            int dx = x+dirx[i];
            int dy = y+diry[i];

            if (dx >= 0 && dx < map[0].length && dy >= 0 && dy < map.length) {
                if(!visit[dy][dx] && map[dy][dx] != 'X'){
                    visit[dy][dx] = true;
                    val += bfs(dy, dx);
                }
            }
        }
        return val;
    }
}