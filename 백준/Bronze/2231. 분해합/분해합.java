import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int length = n.length();
        int num = Integer.parseInt(n);
        int answer = 0;

        for (int i = (num - (length * 9));  i < num; i++) {
            int number = i;
            int sum = 0;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum + i == num) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}