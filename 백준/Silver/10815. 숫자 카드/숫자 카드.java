import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(st.nextToken()), 0);
        }

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(map.containsKey(Integer.parseInt(st.nextToken())) ? 1 : 0).append(" ");
        }

        System.out.println(builder);
    }
}