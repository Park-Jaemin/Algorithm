import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int[] sort;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        
        int[] arr = new int[count];
        sort = new int[arr.length];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr, 0, arr.length-1);
        for (int num : arr) {
            builder.append(num).append("\n");
        }

        System.out.println(builder);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int k = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                sort[k++] = arr[i++];
            } else {
                sort[k++] = arr[j++];
            }
        }

        if (i > mid) {
            for (int l = j; l <= right; l++) {
                sort[k++] = arr[l];
            }
        } else {
            for (int l = i; l <= mid; l++) {
                sort[k++] = arr[l];
            }
        }

        if (right + 1 - left >= 0) System.arraycopy(sort, left, arr, left, right + 1 - left);
    }
}