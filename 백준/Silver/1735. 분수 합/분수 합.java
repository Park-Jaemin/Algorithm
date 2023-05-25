import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mol1 = Integer.parseInt(st.nextToken());
        int den1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int mol2 = Integer.parseInt(st.nextToken());
        int den2 = Integer.parseInt(st.nextToken());
        int num1 = getNum(den1, den2);

        int resultMol = mol1 * (den2/num1) + mol2 * (den1/num1);
        int resultDen = den1*den2/num1;
        int num2 = getNum(resultMol, resultDen);

        System.out.println(resultMol/num2 + " " + resultDen/num2);
    }
    
    private static int getNum (int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}