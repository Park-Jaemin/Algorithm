import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long num = getNum(n);
        System.out.println(num);
    }

    private static long getNum(int n) {
        if (n <= 1) return n;
        return getNum(n - 2) + getNum(n - 1);
    }
}