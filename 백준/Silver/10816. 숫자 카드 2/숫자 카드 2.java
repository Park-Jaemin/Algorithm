import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
        }

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                builder.append(map.get(key));
            } else {
                builder.append(0);
            }
            builder.append(" ");
        }

        System.out.println(builder);
    }
}