import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String replaceMelody = replaceMelody(m);
        String answer = "(None)";
        long answerMelodyLength = 0;

        for (String info : musicinfos) {
            String[] split = info.split(",");

            long limit = getPlayTime(split[0], split[1]);
            String playMusic = playMusic(replaceMelody(split[3]), limit);

            if (playMusic.contains(replaceMelody) && answerMelodyLength < limit) {
                answer = split[2];
                answerMelodyLength = limit;
            }
        }

        return answer;
    }
    
    long getPlayTime(String start, String end) {
        return ChronoUnit.MINUTES.between(LocalTime.parse(start), LocalTime.parse(end));
    }
    
    String replaceMelody(String melody) {
        return melody.replace("C#", "c").replace("D#", "d")
                .replace("F#", "f").replace("G#", "g")
                .replace("A#", "a");
    }
    
    String playMusic(String music, long limit) {   
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            temp.append(music.charAt(i % music.length()));
        }
        return temp.toString();
    }
}