import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            long n = Long.parseLong(br.readLine());
            BigInteger bigInteger = new BigInteger(String.valueOf(n));
            if (bigInteger.isProbablePrime(10)) {
                builder.append(bigInteger);
            } else {
                builder.append(bigInteger.nextProbablePrime());
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}