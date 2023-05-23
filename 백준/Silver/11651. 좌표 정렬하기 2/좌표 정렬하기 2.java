import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        int[][] arr = new int[count][2];

        for (int i = 0; i < count; i++) {
            String[] coordinate = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(coordinate[0]);
            arr[i][1] = Integer.parseInt(coordinate[1]);
        }

        Arrays.sort(arr, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0]-o2[0];
            }
            return o1[1] - o2[1];
        }));

        for (int[] coordinate : arr) {
            builder.append(coordinate[0]).append(" ").append(coordinate[1]).append("\n");
        }
        System.out.println(builder);
    }
}
