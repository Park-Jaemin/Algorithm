import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            for (int j = 0; j+i <= line.length(); j++) {
                set.add(line.substring(j, j+i));
            }
        }

        System.out.println(set.size());
    }
}