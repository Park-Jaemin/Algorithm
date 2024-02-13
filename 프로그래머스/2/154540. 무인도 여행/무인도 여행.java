import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        char[][] map = convertMap(maps);
        boolean[][] visit = new boolean[map.length][map[0].length];
        
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (canArrive(i, j, map, visit)) {
                    queue.offer(getDay(i, j, map, visit));
                }
            }
        }
        
        if (queue.isEmpty()) {
            return new int[]{-1};
        }
        
        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }
        
        return answer;
    }
    
    char[][] convertMap(String[] maps) {
        int length = maps.length;
        char[][] map = new char[length][];
        for (int i = 0; i < length; i++) {
            map[i] = maps[i].toCharArray();
        }
        return map;
    }
    
    int getDay(int i, int j, char[][] map, boolean[][] visit) {
        if (inRange(i, j, map) || !canArrive(i, j, map, visit)) {
            return 0;
        }
        int day = Character.getNumericValue(map[i][j]);
        visit[i][j] = true;
        
        day += getDay(i+1, j, map, visit);
        day += getDay(i-1, j, map, visit);
        day += getDay(i, j+1, map, visit);
        day += getDay(i, j-1, map, visit);
        
        return day;
    }
    
    boolean inRange(int i, int j, char[][] map) {
        return i < 0 || i >= map.length || j < 0 || j >= map[0].length;
    }
    
    boolean canArrive(int i, int j, char[][] map, boolean[][] visit) {
        return !visit[i][j] && map[i][j] != 'X';
    }
}