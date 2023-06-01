import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int head = 10000-1;
    static int tail = 10000-1;
    static int[] deque = new int[20000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] line = br.readLine().split(" ");

            switch (line[0]) {
                case "push_front" :
                    pushFront(Integer.parseInt(line[1]));
                    break;
                case "push_back" :
                    pushBack(Integer.parseInt(line[1]));
                    break;
                case "pop_front" :
                    sb.append(popFront()).append("\n");
                    break;
                case "pop_back" :
                    sb.append(popBack()).append("\n");
                    break;
                case "size" :
                    sb.append(size()).append("\n");
                    break;
                case "empty" :
                    sb.append(empty()).append("\n");
                    break;
                case "front" :
                    sb.append(front()).append("\n");
                    break;
                case "back" :
                    sb.append(back()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    static void pushFront(int value) {
        deque[head--] = value;
    }

    static void pushBack(int value) {
        deque[++tail] = value;
    }

    static int popFront() {
        return tail - head == 0 ? -1 : deque[++head];
    }

    static int popBack() {
        return tail - head == 0 ? -1 : deque[tail--];
    }

    static int size() {
        return tail - head;
    }

    static int empty() {
        return tail - head == 0 ? 1 : 0;
    }

    static int front() {
        return tail - head == 0 ? -1 : deque[head+1];
    }

    static int back() {
        return tail - head == 0 ? -1 : deque[tail];
    }
}
