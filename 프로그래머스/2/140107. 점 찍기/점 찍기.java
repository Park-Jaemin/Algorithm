class Solution {
    public long solution(long k, long d) {
        long answer = 0;
        
        for (long i = 0; i <= d; i += k) {
            long line = (long) Math.sqrt(d*d - i*i);
            answer += line / k + 1;
        }
        
        return answer;
    }
}