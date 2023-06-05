import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sb.append(isPalindrome(br.readLine())).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static int isPalindrome(String s){
        count = 0;
        return recursion(s, 0, s.length()-1);
    }

    public static int recursion(String s, int l, int r){
        count++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
}