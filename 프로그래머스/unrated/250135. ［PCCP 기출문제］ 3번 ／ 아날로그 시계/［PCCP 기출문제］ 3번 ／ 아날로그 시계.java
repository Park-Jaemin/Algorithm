class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        long now = toSecondTime(h1, m1, s1);
        long end = toSecondTime(h2, m2, s2);
        
        if (now == 0 || now == 12 * 3600L) answer++;
        
        while (now < end) {
            double nowH = now / 120.0 % 360;
            double nowM = now / 10.0 % 360;
            double nowS = now * 6 % 360;
            
            double nextH = (now + 1) / 120.0 % 360 == 0 ? 360 : (now + 1) / 120.0 % 360;
            double nextM = (now + 1) / 10.0 % 360 == 0 ? 360 : (now + 1) / 10.0 % 360;
            double nextS = (now + 1) * 6 % 360 == 0 ? 360 : (now + 1) * 6 % 360;
         
            if (nowS < nowH && nextS >= nextH) answer++;
            if (nowS < nowM && nextS >= nextM) answer++;
            if (nextM == nextH) answer--;
            
            now++;
        }
        
        return answer;
    }
    
    long toSecondTime(int h, int m, int s) {
        return h * 3600L + m * 60 + s;
    }
}