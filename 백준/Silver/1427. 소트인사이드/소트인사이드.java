import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String line = br.readLine();
        int[] arr = new int[line.length()];
        int[] result = new int[line.length()];
        int[] counting = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(line.charAt(i)));
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

        for (int i = result.length - 1; i >= 0; i--) {
            builder.append(result[i]);
        }

        System.out.println(builder);
    }
}