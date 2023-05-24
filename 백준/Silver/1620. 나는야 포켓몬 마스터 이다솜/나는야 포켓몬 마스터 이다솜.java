import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[n + 1];
        int index = 1;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, index++);
            arr[i+1] = name;
        }

        n = Integer.parseInt(st.nextToken());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            try {
                builder.append(arr[Integer.parseInt(line)]);
            } catch (NumberFormatException e) {
                builder.append(map.get(line));
            } finally {
              builder.append("\n");
            }
        }
        System.out.println(builder);
    }
}