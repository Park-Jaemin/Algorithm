import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] prime = new boolean[246913];
        int[] count = new int[246913];
        getPrime(prime);
        getCount(prime, count);

        String line;
        while (!(line = br.readLine()).equals("0")) {
            int n = Integer.parseInt(line);
            sb.append(count[2 * n] - count[n]).append("\n");
        }
        System.out.println(sb);
    }

    public static void getPrime(boolean[] prime) {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }

    public static void getCount(boolean[] prime, int[] count) {
        int n = 0;
        for(int i = 2; i < prime.length; i++) {
            if(!prime[i]) n++;
            count[i] = n;
        }
    }
}