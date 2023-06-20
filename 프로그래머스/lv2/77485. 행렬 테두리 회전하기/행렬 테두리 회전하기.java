class Solution {
    
    static int[][] map;
    static int[] answer;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        initMap(rows, columns);
        answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotation(queries[i]);
        }

        return answer;
    }
    
    void initMap(int rows, int columns) {
        map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = i * map[i].length + j + 1;
            }
        }
    }
    
    int rotation(int[] rotationInfo) {
        int min = 100*100+1;

        int x1 = rotationInfo[0]-1;
        int x2 = rotationInfo[2]-1;
        int y1 = rotationInfo[1]-1;
        int y2 = rotationInfo[3]-1;

        int start = map[x1][y1];

        for (int i = x1; i < x2; i++) { // 왼쪽 하단방향
            min = Math.min(min, map[i][y1] = map[i+1][y1]);
        }
        for (int i = y1; i < y2; i++) { // 하단 오른쪽방향
            min = Math.min(min, map[x2][i] = map[x2][i+1]);
        }
        for (int i = x2; i > x1; i--) { // 오른쪽 상단방향
            min = Math.min(min, map[i][y2] = map[i-1][y2]);
        }
        for (int i = y2; i > y1; i--) { // 상단 왼쪽방향
            min = Math.min(min, map[x1][i] = map[x1][i-1]);
        }

        min = Math.min(min, map[x1][y1+1] = start);

        return min;
    }
}