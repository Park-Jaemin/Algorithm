import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long result = multiplication(a, b, c);
        System.out.println(result);
    }

    static long multiplication(int num, int index, int c) {
        if (index == 1) {
            return num % c;
        }

        long result = multiplication(num, index / 2, c);
        result = result * result % c;

        if (index % 2 == 1) {
            return result * num % c;
        }

        return result;
    }
}