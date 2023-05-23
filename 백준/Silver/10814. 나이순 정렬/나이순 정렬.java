import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        String[][] arr = new String[count][2];
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            String[] info = line.split(" ");
            arr[i][0] = info[0];
            arr[i][1] = info[1];
        }
        Arrays.sort(arr, ((o1, o2) -> {
            int a = Integer.parseInt(o1[0]);
            int b = Integer.parseInt(o2[0]);
            if (a == b) {
                return 0;
            }
            return a - b;
        }));

        for (String[] info : arr) {
            builder.append(info[0]).append(" ").append(info[1]).append("\n");
        }
        System.out.println(builder);
    }
}