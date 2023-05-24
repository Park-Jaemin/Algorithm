import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        Set<String> answer = new TreeSet<>();
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String key = br.readLine();
            if (set.contains(key)) {
                answer.add(key);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String name : answer) {
            builder.append(name).append("\n");
        }
        System.out.println(answer.size());
        System.out.println(builder);
    }
}