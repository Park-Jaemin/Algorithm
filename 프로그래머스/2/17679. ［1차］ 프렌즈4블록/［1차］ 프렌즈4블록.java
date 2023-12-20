import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = divideMap(m, n, board);  
        return play(m, n, map);
    }
    
    char[][] divideMap(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        return map;
    }
    
    int play(int m, int n, char[][] map) {
        Set<String> set = find(m, n, map);
        if (set.size() == 0) return 0;
        remove(m, n, map, set);
        return set.size() + play(m, n, map);
    }
    
    Set<String> find(int m, int n, char[][] map) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m -1; i++) {
            for (int j = 0; j < n -1; j++) {
                char block = map[i][j];
                if (block == '-') continue;
                
                String[] collectMap = new String[4];
                if (isCollect4Block(i, j, block, map, collectMap)) {
                    set.addAll(Arrays.asList(collectMap));
                }
            }
        }
        return set;
    }
    
    boolean isCollect4Block(int i, int j, char block, char[][] map, String[] collectMap) {
        int idx = 0;
        for (int x = i; x <= i+1; x++) {
            for (int y = j; y <= j+1; y++) {
                if (block != map[x][y]) return false;
                collectMap[idx++] = x+" "+y;
            }
        }
        return true;
    }
    
    void remove(int m, int n, char[][] map, Set<String> set) {
        for (String coordinate : set) {
            String[] s = coordinate.split(" ");
            map[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = '-';
        }
        change(m, n, map);
    }
    
    void change(int m, int n, char[][] map) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] != '-') continue;
                int temp = i;
                while (temp > 0 && map[temp][j] == '-') {
                    temp--;
                }
                map[i][j] = map[temp][j];
                map[temp][j] = '-';
            }
        }
    }
}