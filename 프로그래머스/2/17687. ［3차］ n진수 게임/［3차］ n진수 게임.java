class Solution {
    public String solution(int n, int t, int m, int p) {   
        int number = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < t*m) {
            sb.append(Integer.toString(number++, n));
        }
        
        StringBuilder answer = new StringBuilder();
        int i = p-1;
        while (answer.length() < t) {
            answer.append(sb.charAt(i));
            i += m;
        }
        
        return answer.toString().toUpperCase();
    }
}