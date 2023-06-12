class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int x = -1; // x 좌표
        int y = 0; // y 좌표
        int val = 1; // 달팽이 채우기 값
        
        
        
        // 0,0 / 0,1 / 0,2 / 0,3
        // 1,1 / 1,2 / 1,3
        // 2,2 / 2,3
        // 3,3
            
        for(int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { 
                if (i % 3 == 0) { // 세로
                    x++;
                } else if (i % 3 == 1) { // 가로
                    y++;
                } else {
                    x--;
                    y--;
                }
                arr[x][y] = val++; // 11
            }
        }
        
        //?000
        //??nn
        //???n
        //????

        // 0, 0
        // 1, 0 / 1,1
        // 2, 0 / 2,1 / 2,2
        int[] answer = new int[val - 1]; // 10
        val = 0;
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j <= i; j++) {
                answer[val++] = arr[i][j];
            }
        }

        return answer;
    }
}