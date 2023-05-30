import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            if (line.equals("ENTER")) {
                answer += set.size();
                set = new HashSet<>();
            } else {
                set.add(line);
            }
        }
        answer += set.size();
        System.out.println(answer);
    }
}
