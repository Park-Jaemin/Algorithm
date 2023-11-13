import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        int now = 0;
        int n = Integer.parseInt(br.readLine()) - 1;

        int[] km = new int[n];
        int[] pay = new int[n];

        StringTokenizer kmToken = new StringTokenizer(br.readLine());
        StringTokenizer payToken = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            km[i] = Integer.parseInt(kmToken.nextToken());
            pay[i] = Integer.parseInt(payToken.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (now >= km[i]) {
                now -= km[i];
                continue;
            }

            int currentPay = pay[i];
            int move = 0;
            int j = i;
            while (j < n && currentPay <= pay[j]) {
                move += km[j];
                j++;
            }

            total += move * currentPay;
            now += move;
        }

        System.out.println(total);
    }
}