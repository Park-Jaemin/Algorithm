import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            if (line.length() < length) continue;

            map.put(line, map.get(line) == null ? 1 : map.get(line)+1);
        }

        TreeSet<String> sort = new TreeSet<>((o1, o2) -> {
            if (map.get(o1).intValue() == map.get(o2).intValue()) {
                if (o2.length() == o1.length()) return o1.compareTo(o2);
                return o2.length() - o1.length();
            }
            return map.get(o2) - map.get(o1);
        });
        sort.addAll(map.keySet());

        for (String word : sort) {
            bw.append(word).append("\n");
        }
        bw.flush();
    }
}