import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 삽입 정렬
        for (int i = 1; i < count; i++) {
            int key = arr[i]; // 2
            int index = i - 1; //

            while (index >= 0 && key < arr[index]) {
                arr[index+1] = arr[index];
                index--;
            }

            arr[index+1] = key;
        }
        
        for (int num : arr) {
            System.out.println(num);
        }
    }
}