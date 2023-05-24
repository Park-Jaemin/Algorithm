import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            if (set.contains(br.readLine())) count++;
        }

        System.out.println(count);
    }
}