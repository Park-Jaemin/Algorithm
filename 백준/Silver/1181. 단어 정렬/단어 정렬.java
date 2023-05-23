import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        TreeSet<String> words = new TreeSet<>(((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        }));

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            words.add(br.readLine());
        }

        for (String msg : words) {
            builder.append(msg).append("\n");
        }
        System.out.println(builder);
    }
}