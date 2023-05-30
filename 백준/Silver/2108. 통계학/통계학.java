import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[8001];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int mid = 4001;
        int mode = 4001;

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[num + 4000]++;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int count = 0;
        int modeMax = 0;

        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if (arr[i] == 0) continue;

            if (count <= (n - 1) / 2) {
                count += arr[i];
                mid = i - 4000;
            }

            if (modeMax < arr[i]) {
                modeMax = arr[i];
                mode = i - 4000;
                flag = true;
            } else if (modeMax == arr[i] && flag) {
                mode = i - 4000;
                flag = false;
            }
        }

        System.out.println((int) Math.round((double) sum / n));	// 산술평균
        System.out.println(mid);	// 중앙값
        System.out.println(mode);	// 최빈값
        System.out.println(max - min);	// 범위
    }
}