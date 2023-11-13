import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.MAX_VALUE;

        String[] split = br.readLine().split("-");
        for (String s : split) {
            int temp = 0;

            String[] split2 = s.split("\\+");
            for (String num : split2) {
                temp += Integer.parseInt(num);
            }

            answer = answer == Integer.MAX_VALUE ? temp : answer - temp;
        }

        System.out.println(answer);
    }
}