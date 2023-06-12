class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int x = -1; // x 좌표
        int y = 0; // y 좌표
        int val = 1; // 달팽이 채우기 값

        for(int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                arr[x][y] = val++;
            }
        }

        int[] answer = new int[val - 1];
        val = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[val++] = arr[i][j];
            }
        }

        return answer;
    }
}