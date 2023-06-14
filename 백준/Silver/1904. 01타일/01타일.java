import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n));
    }

    static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        } 
        if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = (a + b)%15746;
            a = b;
            b = c;
        }

        return c;
    }
}