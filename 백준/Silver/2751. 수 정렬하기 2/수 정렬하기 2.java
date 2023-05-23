import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 라이브러리 제공 정렬
        Arrays.sort(arr);

        StringBuilder builder = new StringBuilder();
        for (int num : arr) {
            builder.append(num).append("\n");
        }
        System.out.println(builder);
    }
}