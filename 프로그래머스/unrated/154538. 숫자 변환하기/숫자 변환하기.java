import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        boolean[] visit = new boolean[y+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});
        visit[x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            int count = poll[1];

            if (cur == y) return count;

            if (cur+n <= y && !visit[cur+n]) {
                visit[cur+n] = true;
                queue.offer(new int[]{cur+n, count+1});
            }
            if (2*cur <= y && !visit[2*cur]) {
                visit[2*cur] = true;
                queue.offer(new int[]{2*cur, count+1});
            }
            if (3*cur <= y && !visit[3*cur]) {
                visit[3*cur] = true;
                queue.offer(new int[]{3*cur, count+1});
            }
        }
        return -1;
    }
}