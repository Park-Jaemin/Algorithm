import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String active = br.readLine();

            switch (active) {
                case "pop" :    builder.append(pop()).append("\n");  break;
                case "size" :   builder.append(size()).append("\n"); break;
                case "empty" :  builder.append(empty()).append("\n");    break;
                case "top" :    builder.append(top()).append("\n");  break;
                default :   push(Integer.parseInt(active.split(" ")[1]));
            }
        }
        System.out.println(builder);
    }

    static int pop() {
        int num = -1;
        if (list.size()-1 >= 0) {
            num = list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
        return num;
    }

    static int size() {
        return list.size();
    }

    static int empty() {
        return list.size() == 0 ? 1 : 0;
    }

    static int top() {
        return list.size()-1 >= 0 ? list.get(list.size()-1) : -1;
    }

    static void push(int num) {
        list.add(num);
    }
}