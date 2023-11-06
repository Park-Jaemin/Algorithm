import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static Long[] arr = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            sb.append(pado(Integer.parseInt(br.readLine()))).append("\n");
        }

        System.out.println(sb);
    }

    public static long pado(int n) {
        if (arr[n] == null) {
            arr[n] = pado(n-2) + pado(n-3);
        }
        return arr[n];
    }
}