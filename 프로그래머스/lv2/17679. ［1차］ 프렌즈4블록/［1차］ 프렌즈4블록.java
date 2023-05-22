import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        Set<String> set;
        int count = 0;
        while (true) {
            set = new HashSet<>();
            find(m, n, map, set);
            if (set.size() == 0) break;
            count += set.size();
            remove(map, set);
            change(m, n, map);
        }
        return count;
    }
    
    private void find(int m, int n, char[][] map, Set<String> set) {
        for (int i = 0; i < m -1; i++) {
            for (int j = 0; j < n -1; j++) {
                char block = map[i][j];
                if (block == '-') continue;

                boolean collect = true;
                String[] collectMap = new String[4];
                int idx = 0;
                for (int x = i; collect && x <= i+1; x++) {
                    for (int y = j; y <= j+1; y++) {
                        if (block != map[x][y]) {
                            collect = false;
                            break;
                        }
                        collectMap[idx] = x + " " + y;
                        idx++;
                    }
                }

                if (collect) {
                    set.addAll(Arrays.asList(collectMap));
                }
            }
        }
    }
    
    private void remove(char[][] map, Set<String> set) {
        for (String coordinate : set) {
            String[] s = coordinate.split(" ");
            map[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = '-';
        }
    }
    
    private void change(int m, int n, char[][] map) {
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