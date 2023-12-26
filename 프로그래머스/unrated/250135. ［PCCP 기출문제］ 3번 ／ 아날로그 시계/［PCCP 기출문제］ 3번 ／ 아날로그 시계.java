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

// 초침 = 360º / 60s    -> 6 / 1s
// 분침 = 360º / 3600s  -> 1/10 / 1s
// 시침 = 360º / 43200s -> 1/120 / 1s

// 01시or13시 -> 시침 30도
// 3600 or 46,800 -> 30도
// 3600/120 or 46800/120 % 360 

// 00 : 05 : 30 -> 00 : 07 : 00
// 초침 1반퀴 반 360 + 180 = 540
// 분침 9


// 시침 1Cycle에 분침과 만나는 횟수 - 22번 -> 시침 360 , 분침 43200도

// 시침 1Cycle에 초침과 만나는 횟수 - 
