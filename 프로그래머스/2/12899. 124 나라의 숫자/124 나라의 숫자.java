class Solution {
    public String solution(int num) {
        StringBuilder sb = new StringBuilder();
        
        while(num > 0) {
            int val = num % 3;
            sb.insert(0, val == 0 ? "4" : val);

            if (val == 0) {
                num = num/3 - 1;
            } else {
                num /= 3;
            }
        }

        return sb.toString();
    }
}