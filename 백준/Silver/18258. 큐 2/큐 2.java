import java.io.*;

public class Main {
    static int front = 0;
    static int back = 0;
    static int[] list = new int[2_000_000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String line = br.readLine();

            switch (line) {
                case "pop" : bw.write(pop()+"\n"); break;
                case "size" : bw.write(size()+"\n"); break;
                case "empty" : bw.write(empty()+"\n"); break;
                case "front" : bw.write(front()+"\n"); break;
                case "back" : bw.write(back()+"\n"); break;
                default : push(Integer.parseInt(line.split(" ")[1])); break;
            }
        }
        bw.flush();
    }

    static int pop() {
        if (back - front == 0) {
            return -1;
        }
        return list[front++];
    }

    static int size() {
        return back - front;
    }

    static int empty() {
        return back - front == 0 ? 1 : 0;
    }

    static int front() {
        return back - front == 0 ? -1 : list[front];
    }

    static int back() {
        return back - front == 0 ? -1 : list[back -1];
    }

    static void push(int num) {
        list[back++] = num;
    }
}