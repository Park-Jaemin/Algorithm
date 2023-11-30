class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int col = 3;
        int row = total;
        for (; col <= row; col++) {
            if (total % col == 0) {
                row = total / col;
            }

            if ((col - 2) * (row - 2) == yellow) {
                return new int[]{row, col};
            }
        }

        return null;
    }
}

/*
    row = 가로
    col = 세로
    
    row >= col
    row * col = brown + yellow
    row * col - ((row-2) * (col-2)) = brown
    row * col - ((row-2) * (col-2))
    (row-2) * (col-2) = yellow
    row * col = brown + ((row-2) * (col*2))
    
    row * col - ((row-2) * (col-2)) - brown = 0
    
    4 * 3 = 10 + ((4-2) * (3-2))
    12 = 10 + 2
*/