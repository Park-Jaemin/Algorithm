class Solution {
    
    int[] answer = new int[]{0,0};
    
    public int[] solution(int[][] arr) {
        dfs(arr, 0, 0, arr.length);
        return answer;
    }
    
    void dfs(int[][] arr, int x, int y, int n) {
        int value = arr[x][y];

        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (arr[i][j] != value) {
                    int cutSize = n / 2;
                    dfs(arr, x, y, cutSize);
                    dfs(arr, x, y + cutSize, cutSize);
                    dfs(arr, x + cutSize, y, cutSize);
                    dfs(arr, x + cutSize, y + cutSize, cutSize);
                    return;
                }
            }
        }
        answer[value] += 1;
    }
}