import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());
            sum += score;
            arr[i] = score;

            int j = i - 1;
            while (j >= 0 && arr[j] > score) {
                arr[j+1] = arr[j];
                arr[j] = score;
                j--;
            }
        }
        System.out.println(sum / 5);
        System.out.println(arr[2]);
    }
}