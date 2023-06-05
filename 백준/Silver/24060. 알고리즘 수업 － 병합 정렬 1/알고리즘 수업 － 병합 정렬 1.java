import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tmp;
    static int k;
    static int count = 0;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] a = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(a, 0, a.length-1);
        System.out.println(result);
    }

    static void mergeSort(int[] a, int left, int right) {
        if (count > k) return;
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);      // 전반부 정렬
            mergeSort(a, mid + 1, right);  // 후반부 정렬
            merge(a, left, mid, right);        // 병합
        }
    }

    static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                tmp[t++] = a[i++];
            } else {
                tmp[t++] = a[j++];
            }
        }

        while (i <= q) { // 왼쪽 배열 부분이 남은 경우
            tmp[t++] = a[i++];
        }

        while (j <= r) { // 오른쪽 배열 부분이 남은 경우
            tmp[t++] = a[j++];
        }

        i = p;
        t = 0;
        while (i <= r) { // 결과를 A[p..r]에 저장
            count++;
            if (count == k) {
                result = tmp[t];
                break;
            }

            a[i++] = tmp[t++];
        }
    }
}
