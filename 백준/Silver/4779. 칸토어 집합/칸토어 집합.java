import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            arr = new char[(int) Math.pow(3, n)];
            Arrays.fill(arr, '-');

            func(0, arr.length);
            sb.append(arr).append("\n");
        }
        System.out.println(sb);
    }

    static void func(int start, int size) {
        if (size == 1) {
            return;
        }
        int newSize = size/3;
        Arrays.fill(arr, start+newSize, start+2*newSize, ' ');

        func(start, newSize);
        func(start+2*newSize, newSize);
    }
}
