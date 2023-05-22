import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(br.readLine());

        int a = weight / 5;
        for (int x = a; x >= 0; x--) {
            for (int y = 0; y*3 <= weight; y++) {
                if (5*x + 3*y == weight) {
                    System.out.println(x+y);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}