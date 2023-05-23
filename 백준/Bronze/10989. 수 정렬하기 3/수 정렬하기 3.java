import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        int[] result = new int[count];
        int[] counting = new int[10000+1];

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int num : arr) {
            counting[num]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }

        for (int i = arr.length-1; i >= 0; i--) {
            int value = arr[i];
            int index = --counting[value];

            result[index] = value;
        }

        StringBuilder builder = new StringBuilder();
        for (int num : result) {
            builder.append(num).append("\n");
        }
        System.out.println(builder);
    }
}