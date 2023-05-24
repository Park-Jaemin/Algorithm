import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        init(br, n, a);
        init(br, m, b);
        Set<Integer> copyA = new HashSet<>(a);

        a.removeAll(b);
        b.removeAll(copyA);

        System.out.println(a.size() + b.size());
    }

    private static void init(BufferedReader br, int count, Set<Integer> set) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < count; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }
    }
}