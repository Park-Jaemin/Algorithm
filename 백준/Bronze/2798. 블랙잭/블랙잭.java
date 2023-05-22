import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int[] cards = new int[count];
        int sum = 0;
        int answer = 0;

        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < count; i++) {
            cards[i] = Integer.parseInt(arr[i]);
        }

        boolean flag = true;
        for (int a = 0; flag && a < count; a++) {
            for (int b = a+1; flag && b < count; b++) {
                for (int c = b+1; flag && c < count; c++) {
                    sum = cards[a] + cards[b] + cards[c];
                    if (sum <= limit && answer < sum) {
                        answer = sum;
                        flag = sum != limit;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}