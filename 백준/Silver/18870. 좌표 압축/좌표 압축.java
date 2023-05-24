import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[count];
        int[] copy = new int[count];

        for (int i = 0; i < count; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
            copy[i] = value;
        }
        Arrays.sort(copy);

        int rank = 0;
        for (int num : copy) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        for (int num : arr) {
            builder.append(map.get(num)).append(" ");
        }
        System.out.println(builder);
    }
}