import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        int[] arr = new int[count];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];

            for (int j = i - 1; j >= 0 && key < arr[j]; j--) {
                arr[j+1] = arr[j];
                arr[j] = key;
            }
        }

        System.out.println(arr[arr.length - limit]);
    }
}