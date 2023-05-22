import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 666;
        int count = Integer.parseInt(br.readLine());
        int temp = 1;

        while (count != temp) {
            num++;
            if (String.valueOf(num).contains("666")) {
                temp++;
            }
        }
        System.out.println(num);
    }
}
