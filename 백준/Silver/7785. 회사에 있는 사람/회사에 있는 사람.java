import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");

            if (info[1].equals("leave")) {
                set.remove(info[0]);
            } else {
                set.add(info[0]);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String name : set) {
            builder.append(name).append("\n");
        }

        System.out.println(builder);
    }
}