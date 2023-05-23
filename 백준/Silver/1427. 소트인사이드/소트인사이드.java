import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String line = br.readLine();
        char[] arr = new char[line.length()];

        for (int i = 0; i < line.length(); i++) {
            arr[i] = line.charAt(i);
        }
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]);
        }

        System.out.println(builder);
    }
}