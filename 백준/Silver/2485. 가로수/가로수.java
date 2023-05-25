import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int before = Integer.parseInt(br.readLine());
        int start = before;
        int gcd = 0;
        for (int i = 1; i < count; i++) {
            int after = Integer.parseInt(br.readLine());
            gcd = gcd(after - before, gcd);
            before = after;
        }

        System.out.println((before - start)/gcd + 1 - count);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}