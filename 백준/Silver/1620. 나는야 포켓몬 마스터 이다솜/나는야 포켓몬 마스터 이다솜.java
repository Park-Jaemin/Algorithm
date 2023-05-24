import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int index = 1;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, index++);
            list.add(name);
        }

        n = Integer.parseInt(st.nextToken());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            try {
                builder.append(list.get(Integer.parseInt(line)-1));
            } catch (NumberFormatException e) {
                builder.append(map.get(line));
            } finally {
              builder.append("\n");
            }
        }
        System.out.println(builder);
    }
}