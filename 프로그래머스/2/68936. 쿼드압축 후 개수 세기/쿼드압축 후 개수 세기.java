class Solution {
    public int[] solution(int[][] arr) {
        return dfs(arr, 0, 0, arr.length, new int[2]);
    }

    int[] dfs(int[][] arr, int x, int y, int n, int[] answer) {
        int value = arr[x][y];

        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (arr[i][j] != value) {
                    int cutSize = n / 2;
                    dfs(arr, x, y, cutSize, answer);
                    dfs(arr, x, y + cutSize, cutSize, answer);
                    dfs(arr, x + cutSize, y, cutSize, answer);
                    dfs(arr, x + cutSize, y + cutSize, cutSize, answer);
                    return answer;
                }
            }
        }
        answer[value] += 1;
        
        return answer;
    }
}