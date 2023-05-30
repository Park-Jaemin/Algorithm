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
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            String[] rabbit = line.split(" ");

            if (line.contains("ChongChong") || set.contains(rabbit[0]) || set.contains(rabbit[1])) {
                set.add(rabbit[0]);
                set.add(rabbit[1]);
            }
        }
        System.out.println(set.size());
    }
}