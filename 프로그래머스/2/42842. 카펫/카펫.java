class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int col = 3;
        int row = total;
        
        for (; col <= row; col++) {
            if (total % col == 0) {
                row = total / col;
                
                if ((col - 2) * (row - 2) == yellow) {
                    return new int[]{row, col};
                }
            }
        }

        return null;
    }
}